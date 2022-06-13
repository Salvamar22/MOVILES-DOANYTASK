package com.mejia.doanytask.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mejia.doanytask.R
import com.mejia.project.DatePickerFragment
import kotlinx.android.synthetic.main.activity_registrarse.*

class RegistrarseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        editTextDate.setOnClickListener{showDataPickedDialog()}
    }
    private fun showDataPickedDialog() {
        val datePicker = DatePickerFragment{day, month, year ->  onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }
    fun onDateSelected(day:Int, month:Int, year:Int){
        editTextDate.setText("$day/$month/$year")
    }
}