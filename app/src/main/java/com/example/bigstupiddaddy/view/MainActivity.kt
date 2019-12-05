package com.example.bigstupiddaddy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.bigstupiddaddy.R
import com.example.bigstupiddaddy.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.bumptech.glide.Glide
import com.example.bigstupiddaddy.Model.Gif
import com.example.bigstupiddaddy.viewmodel.GifViewModel
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {

    // Creates the viewmodel
    private lateinit var countViewModel: CountViewModel
    private lateinit var gifViewModel: GifViewModel

    lateinit var alarmManager: AlarmManager

    // Sets your counter to = 0 in the begining
    private var counter: Long = 0
    // Gets the user name, so that you can login or continue to build the score with your account
    private fun getUsername() = intent.extras?.get("username").toString().trim()

    // Saved Instance State
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Gets the userCount of the ViewModel Class
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

        gifViewModel = ViewModelProviders.of(this).get(GifViewModel::class.java)
        gifViewModel.getRandomGif("android").observe(this,
            androidx.lifecycle.Observer { loadGif(it) })

        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alert.setOnClickListener {
            val second = 10 * 1000
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("ALARM_MODE", true)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity", " Create : " + Date().toString())
            if (android.os.Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent)

            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent)
            }
        }


        // The Onset Click.
        myButton.setOnClickListener {
            countViewModel.setUserCount(getUsername(), counter + 1)
        }
    }

// this updates the counter, and changes the text field to the new number
    private fun updateCounter(count: Long) {
        counter = count
        cookie_score.text = counter.toString()
    }

    private fun loadGif(gif: Gif) {


        Glide.with(this)
            .load(gif.url)
            .into(GifView)
    }
}