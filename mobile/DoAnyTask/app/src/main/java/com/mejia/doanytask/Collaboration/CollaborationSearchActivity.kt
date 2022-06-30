package com.mejia.doanytask.Collaboration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mejia.doanytask.R

class CollaborationSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collaborationsearch)

        val btnContact: View = findViewById(R.id.button_contact)

        btnContact.setOnClickListener {
            val intent: Intent = Intent(this, CollaborationsContacts:: class.java )
            startActivity(intent)
        }
    }

}