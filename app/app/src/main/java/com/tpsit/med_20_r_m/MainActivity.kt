package com.tpsit.med_20_r_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeInput: TextInputEditText = findViewById(R.id.nomeipnut)
        val cognomeInput: TextInputEditText = findViewById(R.id.cognomeipnut)
        val usernameInput: TextInputEditText = findViewById(R.id.usernameipnut)
        val passwordInput: TextInputEditText = findViewById(R.id.passwordInput)
        val confermapasswordInput: TextInputEditText = findViewById(R.id.ConfermaPassword)
        val mailInput: TextInputEditText = findViewById(R.id.Mail)
        val codicefiscaleInput: TextInputEditText = findViewById(R.id.CodiceFiscale)
        val usertypeInput: RadioGroup = findViewById(R.id.usertype)
        val registerbutton: Button = findViewById(R.id.registerbutton)

        registerbutton.setOnClickListener {
            val nome = nomeInput.text
            val cognome = cognomeInput.text
            val username = usernameInput.text
            val password = passwordInput.text
            val confermapassword = confermapasswordInput.text
            val mail = mailInput.text
            val codicefiscale = codicefiscaleInput.text
            val usertype = usertypeInput.checkedRadioButtonId
            var user = User("$nome", "$cognome","$username", "$mail", "$password", "$codicefiscale", "$usertype")

            if (password == confermapassword) {
                registerUser(user)
            }
        }
    }
}

fun registerUser(user: User) {
    val client = OkHttpClient()
    val url = "localhost:8080" // Inserisci l'URL del tuo servizio Web

    val requestBody = FormBody.Builder()
        .add("nome", user.nome)
        .add("cognome", user.cognome)
        .add("username", user.username)
        .add("mail", user.mail)
        .add("password", user.password)
        .add("codicefiscale", user.codicefiscale)
        .add("usertype", user.usertype)
        .build()

    val request = Request.Builder()
        .url(url)
        .post(requestBody)
        .build()

    val response = client.newCall(request).execute()

    try {
        val response = client.newCall(request).execute()

        if (!response.isSuccessful) {
            // Gestisci il fallimento della registrazione e mostra un messaggio
            println("Registrazione fallita. Riprova.")
        }
        else {
            println("Registrazione avvenuta con successo!")
        }

        // Gestisci la risposta del server
        val responseData = response.body?.string()
        println(responseData)
    } catch (e: IOException) {
        // Gestisci l'eccezione e mostra un messaggio di errore
        println("Errore durante la registrazione: Riprova.")
    }
}

