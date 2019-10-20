package com.example.bigstupiddaddy.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.bigstupiddaddy.R
import com.example.bigstupiddaddy.util.dissapear
import com.example.bigstupiddaddy.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var countViewModel: CountViewModel

    private var counter: Long = 0
    fun getStore() = getPreferences(Context.MODE_PRIVATE)
    var COOKIE_COUNTER_KEY: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this,
        androidx.lifecycle.Observer { updateCounter(it)  })

        myButton.setOnClickListener {
            countViewModel.SetUserCount(getUsername(), count: cookieCounter + 1)
        }

        val usrname = intent.extras?.get("username").toString().trim()
        COOKIE_COUNTER_KEY = usrname

        if(savedInstanceState != null){
            updateCounter(savedInstanceState.getLong(COOKIE_COUNTER_KEY, 0))
        }else if (getStore().contains(COOKIE_COUNTER_KEY)){
            updateCounter(getStore().getLong(COOKIE_COUNTER_KEY, 0))
        }

        myButton.setOnClickListener {
            counter++
            cookie_score.text = counter.toString()
            brandonImage.dissapear()

            myButton.text = when(counter){
                1L -> "stop"
                in 2 .. 9 -> myButton.text.toString().plus("!")
                else -> myButton.text
            }

        }

    }

    private fun updateCounter(count:Long){
        counter = count
        cookie_score.text = "${counter}"
    }

    override fun onPause(){
        super.onPause()
        getStore().edit().putLong(COOKIE_COUNTER_KEY, counter).apply()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run{
            putLong(COOKIE_COUNTER_KEY, counter)
        }

        super.onSaveInstanceState(outState)

    }

}
