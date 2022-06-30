package com.mejia.doanytask.Event

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mejia.doanytask.Collaboration.CollaborationActivity
import com.mejia.doanytask.Configuration.ConfigurationActivity
import com.mejia.doanytask.Organization.OrganizationActivity
import com.mejia.doanytask.Profile.ProfileActivity
import com.mejia.doanytask.R
import com.mejia.doanytask.Task.TaskActivity
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val btn: View = findViewById(R.id.action_add)

        btn.setOnClickListener{
            val intent: Intent = Intent(this, RegistrarseActivity:: class.java)
            startActivity(intent)
        }

        val btner: Button = findViewById(R.id.btn_registrarse)
        btner.setOnClickListener{
            val intent: Intent = Intent(this, CollaborationActivity:: class.java)
            startActivity(intent)
        }

        //Button Tareas
        val buttonTask: Button = findViewById(R.id.btn_task)

        buttonTask.setOnClickListener {
            val intent: Intent = Intent(this, TaskActivity:: class.java)
            startActivity(intent)
        }

        //Button organizacion
        val buttonOrgani: Button = findViewById(R.id.btn_organization)

        buttonOrgani.setOnClickListener {
            val intent: Intent = Intent(this, OrganizationActivity:: class.java)
            startActivity(intent)
        }

        //Button Configuration

        val button_config: Button = findViewById(R.id.btn_configuration)

        button_config.setOnClickListener {
            val intent : Intent = Intent(this, ConfigurationActivity:: class.java)
            startActivity(intent)
        }

        //Button Perfil
        val button_profil: Button = findViewById(R.id.btn_profile)

        button_profil.setOnClickListener {
            val intent : Intent = Intent(this, ProfileActivity:: class.java)
            startActivity(intent)
        }


    }
}