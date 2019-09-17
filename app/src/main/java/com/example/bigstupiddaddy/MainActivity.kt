package com.example.bigstupiddaddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.bigstupiddaddy.util.toggleVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var cookieCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            cookieCounter = savedInstanceState.getInt(COOKIE_COUNTER_KEY,0)
        }

        myButton.setOnClickListener {
            brandonImage.visibility = View.VISIBLE
        }

        myButton.setOnClickListener {
            cookieCounter++
            brandonImage.toggleVisibility()
            cookie_score.text = cookieCounter.toString()
        }


        }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState?.run{
            putInt(COOKIE_COUNTER_KEY, cookieCounter)
        }

        super.onSaveInstanceState(outState, outPersistentState)
    }

    companion object {
        private const val COOKIE_COUNTER_KEY = "cookieCounterKey"
    }

    }
