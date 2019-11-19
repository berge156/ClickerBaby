package com.example.bigstupiddaddy.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.bigstupiddaddy.R
import com.example.bigstupiddaddy.viewmodel.APIrepository
import com.example.bigstupiddaddy.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.bumptech.glide.Glide
import com.example.bigstupiddaddy.Model.Gif

class MainActivity : AppCompatActivity() {

    // Creates the viewmodel
    private lateinit var countViewModel: CountViewModel
    private lateinit var APIrepository: APIrepository

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

        APIrepository = ViewModelProviders.of(this).get(APIrepository::class.java)
        APIrepository.getRandomGif("android").observe(this,
            androidx.lifecycle.Observer { loadGif(it) })


        // The Onset Click.
        myButton.setOnClickListener {
            countViewModel.setUserCount(getUsername(), counter + 1)
        }
    }

// this updates the counter, and changes the text field to the new number
    private fun updateCounter(count: Long) {
        counter = count
        cookie_score.text = counter.toString()

    private fun loadGif(gif: Gif){

    }
        Glide.with(this)
            .load(gif.url)
            .into(GifView)
    }
}