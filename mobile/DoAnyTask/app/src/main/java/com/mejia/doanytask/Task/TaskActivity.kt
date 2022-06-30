package com.mejia.doanytask.Task

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mejia.doanytask.R

class TaskActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val btn: View = findViewById(R.id.action_add)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, AddTaskActivity:: class.java)
            startActivity(intent)
        }
    }
}