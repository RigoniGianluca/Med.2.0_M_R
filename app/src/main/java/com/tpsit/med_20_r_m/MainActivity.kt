package com.tpsit.med_20_r_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usernameInput: TextInputEditText = findViewById(R.id.usernameInput)
        val passwordInput: TextInputEditText = findViewById(R.id.passwordInput)
        val confermapasswordInput: TextInputEditText = findViewById(R.id.ConfermaPassword)
        val mailInput: TextInputEditText = findViewById(R.id.Mail)
        val codicefiscaleInput: TextInputEditText = findViewById(R.id.CodiceFiscale)
        val usertypeInput: RadioGroup = findViewById(R.id.usertype)
        val registerbutton: Button = findViewById(R.id.registerbutton)

        registerbutton.setOnClickListener {
            val username = usernameInput.text
            val password = passwordInput.text
            val confermapassword = confermapasswordInput.text
            val mail = mailInput.text
            val codicefiscale = codicefiscaleInput.text
            val usertype = usertypeInput.checkedRadioButtonId

            var user = User("$username", "$mail", "$password", "$codicefiscale", "$usertype")

            if (password == confermapassword) {
                registerUser(user: User)
            }
        }
    }
}
fun registerUser(user: User){
    // Creazione di un'istanza del servizio Retrofit
    val userService = RetrofitClient.createService(UserService::class.java)

    // Chiamata al metodo di registrazione del servizio Retrofit
    val call = userService.registerUser(user)

    // Eseguire la chiamata asincrona al web service
    call.enqueue(object : Callback<UserResponse> {
        override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
            if (response.isSuccessful) {
                // Registrazione avvenuta con successo, puoi gestire la risposta qui
                val userResponse = response.body()
                // Esegui le operazioni necessarie con i dati ricevuti dal web service
            } else {
                // Gestisci qui il caso in cui la registrazione non ha avuto successo
                // Potresti visualizzare un messaggio di errore all'utente o fare altre operazioni di gestione degli errori
            }
        }

        override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            // Gestisci qui il caso in cui si è verificato un errore durante la chiamata al web service
            // Potresti visualizzare un messaggio di errore all'utente o fare altre operazioni di gestione degli errori
        }
    })
}