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
import com.mejia.doanytask.MainActivity
import com.mejia.doanytask.R
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.databinding.FragmentDayOrWeekBinding
import java.time.LocalDateTime
import java.time.temporal.WeekFields
import java.util.*

class WeeklyFragment : Fragment() {
    private lateinit var binding: FragmentDayOrWeekBinding
    private lateinit var selectedDate: LocalDateTime

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_day_or_week, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedDate = LocalDateTime.now()
        setActionBar()
        setWeekView()
        binding.actionNextDate.setOnClickListener { actionNext(it)}
        binding.actionPreviusDate.setOnClickListener { actionPrevius(it)}
    }

    private fun setActionBar() {
        val dateBar: View = getLayoutInflater().inflate(R.layout.date_app_bar, null)
        val thisButton = dateBar.findViewById<TextView>(R.id.action_to_week)
        thisButton.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.blue_400)))
        thisButton.setTextColor(resources.getColor(R.color.white))

        val aB: ActionBar =(activity as MainActivity).supportActionBar!!
        aB.setCustomView(dateBar)
    }

    private fun setWeekView( ) {
        val firstDayOfWeek: Int = selectedDate.with(WeekFields.of(Locale.US).dayOfWeek(), 1).dayOfMonth
        val lastDayOfWeek: Int = selectedDate.with(WeekFields.of(Locale.US).dayOfWeek(), 7).dayOfMonth


        binding.monthText.text = selectedDate.month.name
        binding.thisDateText.text = "$firstDayOfWeek-$lastDayOfWeek";

        val acts = List<Activity>(3) { it ->
            Activity(
                it.toString(),
                "Evaluación práctica ${it + 1}.\n" ,
                "Alta",
                "Uca.",
                "2022" + selectedDate.month + selectedDate.dayOfMonth,
                "14:30",
                "Presentacion\n" + "Diseño App",
                "", ""
            )
        }

        val activityRecyclerView = binding.activityListRecyclerView
        val activityAdapter = ActivityAdapter()
        activityRecyclerView.apply {
            adapter = activityAdapter
        }
        activityAdapter.setData(acts, 1)

    }

    private fun actionPrevius(view: View) {
        selectedDate = selectedDate.plusDays(-7)
        setWeekView()
    }

    private fun actionNext(view: View) {
        selectedDate = selectedDate.plusDays(7)
        setWeekView()
    }
}