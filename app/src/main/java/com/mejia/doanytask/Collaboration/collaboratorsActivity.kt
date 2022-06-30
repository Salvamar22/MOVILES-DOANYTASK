package com.mejia.doanytask.Collaboration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.activity_collabopeople.*
import kotlinx.android.synthetic.main.activity_collaborators.*

class collaboratorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collaborators)

        val btn1: View = findViewById(R.id.button_tray)

        btn1.setOnClickListener {
            val intent : Intent = Intent(this, CollaborationActivity:: class.java)
            startActivity(intent)
        }

        button_dates.setOnClickListener{
            val dialog = collaboratorsdataActivity()

            dialog.show(supportFragmentManager, "customDialog")
        }

        val search: View = findViewById(R.id.button_search)

        search.setOnClickListener {
            val intent: Intent = Intent(this, CollaborationSearchActivity:: class.java)
            startActivity(intent)
        }

    }

}