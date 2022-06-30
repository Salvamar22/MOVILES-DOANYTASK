package com.mejia.doanytask.Event

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.activity_registerevent.*
import java.util.*

var button: ImageButton? = null
var boxdate : EditText? = null

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerevent)

        inicializarComponentes();

        btnForm.setOnClickListener{
            val dialog = CustomDialogFragment()

            dialog.show(supportFragmentManager, "customDialog")
        }

    }
    //btn.setOnClickListener{showDataPickedDialog()}

    // fecha
    fun inicializarComponentes() {
        button = findViewById(R.id.btn)
        boxdate = findViewById(R.id.editTextDate)
        button?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val Dialogfecha = DatePickerFragment { year, month, day ->  mostrarResultado(year,month,day) }
        Dialogfecha.show(supportFragmentManager, "DatePicker")
    }

    fun mostrarResultado(year: Int, month: Int, day: Int) {
        boxdate?.setText("$day/$month/$year")
    }
    class DatePickerFragment (val listener: (year:Int , month:Int, day:Int) -> Unit): DialogFragment() , DatePickerDialog.OnDateSetListener{

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val c = Calendar.getInstance()
            var year = c.get(Calendar.YEAR)
            var month = c.get(Calendar.MONTH)
            var day = c.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(requireActivity(), this, year, month, day)
        }

        override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
            listener(year, month+1, day)
        }

    }
}