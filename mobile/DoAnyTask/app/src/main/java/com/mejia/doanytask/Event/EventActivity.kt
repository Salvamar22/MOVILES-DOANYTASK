package com.mejia.doanytask.Event

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mejia.doanytask.Login.RegistrarseActivity
import com.mejia.doanytask.R

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_event)

        val btn: View = findViewById(R.id.action_add)

        btn.setOnClickListener{
            val intent: Intent = Intent(this, RegistrarseActivity:: class.java)
            startActivity(intent)
        }

    }
}