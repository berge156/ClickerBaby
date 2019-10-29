package com.example.bigstupiddaddy.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.bigstupiddaddy.R
import com.example.bigstupiddaddy.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    // Creates the viewmodel
    private lateinit var countViewModel: CountViewModel

    // Sets your counter to = 0 in the begining
    private var counter: Long = 0
    // Gets the user name, so that you can login or continue to build the score with your account
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

    // Saved Instance State
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Gets the userCount of the ViewModel Class
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

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
}