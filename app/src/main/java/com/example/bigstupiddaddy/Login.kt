package com.example.bigstupiddaddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import com.example.bigstupiddaddy.util.toggleVisibility
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            loginUsernameField.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(p0: Editable?){

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){

                }

                override fun onTextChanged(p0: CharSequence?,p1: Int, p2: Int, p3: Int ){

                }


            })

            loginButton.setOnClickListener{
                startActivity(Intent(this, MainActivity::class.java).apply{putExtra("username", loginUsernameField.text)})
            }


        }
    }