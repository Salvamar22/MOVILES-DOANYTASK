package com.mejia.doanytask.Collaboration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mejia.doanytask.Event.CustomDialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.activity_collabopeople.*
import kotlinx.android.synthetic.main.activity_registrarse.*

class CollaboPeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collabopeople)
        val bnt: View = findViewById(R.id.button_collabo)

        bnt.setOnClickListener {
            val intent: Intent = Intent(this, collaboratorsActivity::class.java)
            startActivity(intent)
        }

        button_view.setOnClickListener {
            val dialog = CustomDialogCollaboration()

            dialog.show(supportFragmentManager, "customDialog")
        }

        val search: View = findViewById(R.id.button_search)

        search.setOnClickListener {
            val intent: Intent = Intent(this, CollaborationSearchActivity::class.java)
            startActivity(intent)
        }
    }
}
