package com.mejia.doanytask.activities

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mejia.doanytask.MainActivity
import com.mejia.doanytask.R
import com.mejia.doanytask.databinding.FragmentMonthBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields
import java.util.*

class MonthlyFragment : Fragment() {

    private lateinit var binding: FragmentMonthBinding
    private lateinit var selectedDate: LocalDate

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_month, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedDate = LocalDate.now()
        setMonthView()
        binding.actionNextMonth.setOnClickListener { actionNextMonth(it)}
        binding.actionPreviusMonth.setOnClickListener { actionPreviusMonth(it)}
        setActionBar()
    }

    private fun setActionBar() {
        val dateBar: View = getLayoutInflater().inflate(R.layout.date_app_bar, null)
        val thisButton = dateBar.findViewById<TextView>(R.id.action_to_month)
        thisButton.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.blue_400)))
        thisButton.setTextColor(resources.getColor(R.color.white))

        val apo: ActionBar =(activity as MainActivity).supportActionBar!!
        apo.setCustomView(dateBar)
    }

    private fun setMonthView() {
        binding.monthYearText.text = monthYearFromDate(selectedDate)
        val daysInMonth: List<String> = daysInMonthList(selectedDate)

        val calendarRecyclerView = binding.calendarRecyclerView
        val calendarAdapter = CalendarAdapter()

        calendarRecyclerView.layoutManager = GridLayoutManager(context, 7)
        calendarRecyclerView.apply {
            adapter = calendarAdapter
        }
        calendarAdapter.setData(daysInMonth)

    }

    private fun daysInMonthList(selectedDate: LocalDate): List<String> {
        /*val yearMonth: YearMonth = YearMonth.from(selectedDate)
        val daysInMonth = yearMonth.lengthOfMonth()
        val dayOfWeek
        selectedDate.*/

        val calenderDay: LocalDate = selectedDate.withDayOfMonth(1).with(WeekFields.of(Locale.US).dayOfWeek(), 1)

        val daysInMonthList = List<String>(42) {
            val date = calenderDay.plusDays( it.toLong());
            date.dayOfMonth.toString()
        }

        return daysInMonthList
    }

    private fun monthYearFromDate(date: LocalDate): String {
        return date.format(DateTimeFormatter.ofPattern("MMM yyyy"))
    }

    private fun actionPreviusMonth(view: View) {
        selectedDate = selectedDate.plusMonths(-1)
        setMonthView()
    }

    private fun actionNextMonth(view: View) {
        selectedDate = selectedDate.plusMonths(1)
        setMonthView()
    }
}


