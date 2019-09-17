package com.example.bigstupiddaddy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import com.example.bigstupiddaddy.util.toggleVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var cookieCounter: Long = 0
    private val store = getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            Log.d("TEST", "recreating saved state from $savedInstanceState")
            cookieCounter = savedInstanceState.getLong(COOKIE_COUNTER_KEY,0)
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

    override fun onPause() {
        super.onPause()
        store.edit().putLong(COOKIE_COUNTER_KEY, cookieCounter).commit()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState?.run{
            Log.d("TEST", "got to onSaveInstanceState")
            putLong(COOKIE_COUNTER_KEY, cookieCounter)
        }

        super.onSaveInstanceState(outState, outPersistentState)
    }

    companion object {
        private const val COOKIE_COUNTER_KEY = "cookieCounterKey"
    }

    }
