package com.tpsit.med_20_r_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usernameInput: TextInputEditText = findViewById(R.id.usernameInput)
        val passwordInput: TextInputEditText = findViewById(R.id.passwordInput)
        val confermapasswordInput : TextInputEditText = findViewById(R.id.ConfermaPassword)
        val mailInput : TextInputEditText = findViewById(R.id.Mail)
        val codicefiscaleInput : TextInputEditText = findViewById(R.id.CodiceFiscale)
        val registerbutton: Button = findViewById(R.id.registerbutton)

        registerbutton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val confermapassword = confermapasswordInput.text.toString()
            val mail = mailInput.text.toString()
            val codicefiscale = codicefiscaleInput.text.toString()

            val user=User("gigi", "gigi@gmail.com", "gigi", "RGNGLC10A05W43M", "doctor")

            if(password == confermapassword){
                val retrofit = Retrofit.Builder()
                    .baseUrl("localhost")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }


        }
    }
}