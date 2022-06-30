package com.mejia.doanytask.Collaboration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mejia.doanytask.R


class CollaborationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collaboration)

        val btn: View = findViewById(R.id.button_colActive)

        btn.setOnClickListener {
            val intent: Intent = Intent(this, CollaboPeopleActivity:: class.java )
            startActivity(intent)
        }

        val search: View = findViewById(R.id.button_search)

        search.setOnClickListener {
            val intent: Intent = Intent(this, CollaborationSearchActivity:: class.java)
            startActivity(intent)
        }
    }
}