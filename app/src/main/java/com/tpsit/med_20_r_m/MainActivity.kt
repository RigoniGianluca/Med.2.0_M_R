package com.tpsit.med_20_r_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usernameText: TextInputEditText = findViewById(R.id.usernameInput)
        val passwordText: TextInputEditText = findViewById(R.id.passwordInput)
        val loginbutton: Button = findViewById(R.id.loginButton)

        loginbutton.setOnClickListener {
            var username = usernameText.text.toString()
            var password = usernameText.text.toString()
        }
    }
}