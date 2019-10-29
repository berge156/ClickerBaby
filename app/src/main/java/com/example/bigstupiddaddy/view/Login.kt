package com.example.bigstupiddaddy.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.bigstupiddaddy.R
import kotlinx.android.synthetic.main.activity_login.*

// Creates the saved instance of the Login Information
class Login : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            // Changes the text view to the login informaton
            loginUsernameField.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    p0?.apply {
                        loginButton.isEnabled = length > 0

                    }
                }
            })
// Username information, connects this to the button
                loginButton.setOnClickListener {
                    startActivity(Intent(this, MainActivity::class.java).apply { putExtra("username", loginUsernameField.text) })
                }

        }
}