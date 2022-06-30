package com.mejia.doanytask.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mejia.doanytask.Event.EventActivity
import com.mejia.doanytask.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn: Button = findViewById(R.id.btn_registrarse)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, RegistrarseActivity:: class.java)
            startActivity(intent)
        }

        val but: Button = findViewById(R.id.btn_iniciar_sesion)
        but.setOnClickListener {
            val intent: Intent = Intent(this, EventActivity:: class.java )
            startActivity(intent)
        }
    }
}