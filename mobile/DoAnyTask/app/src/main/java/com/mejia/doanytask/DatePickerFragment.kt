package com.mejia.project

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import java.util.*

class DatePickerFragment(val listener: (day:Int, month: Int, year:Int) -> Unit ):DialogFragment(),
    DatePickerDialog.OnDateSetListener {

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val vDay = c.get(Calendar.DAY_OF_MONTH)
        val vMonth = c.get(Calendar.MONTH)
        val vYear = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context,  R.style.datePickerTheme, this, vYear, vMonth, vDay)
        picker.datePicker.maxDate = c.timeInMillis
        return picker
    }
}