package com.mejia.doanytask.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mejia.doanytask.R
import com.mejia.doanytask.databinding.CalendarCellBinding

class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    private var daysOfMonth: List<String>? = null
    fun setData(data: List<String>) {
        this.daysOfMonth = data
        notifyDataSetChanged()
    }

    inner class CalendarViewHolder(private val binding: CalendarCellBinding) : RecyclerView.ViewHolder(binding.root) {
        /*
                private val dayOfMonth: TextView = 0

                CalendarViewHolder(private val binding: CalendarCellBinding) {
                    super(binding.root)
                }
        */
        fun bind(dayOfMonth: String) {
            binding.calendarCellText.text = dayOfMonth
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {

        val cellBinding = DataBindingUtil.inflate<CalendarCellBinding>(
            LayoutInflater.from(parent.context),
            R.layout.calendar_cell,
            parent,
            false
        )

        val layoutParams: ViewGroup.LayoutParams = cellBinding.root.layoutParams;
        layoutParams.height = (parent.height * 0.166666).toInt();

        return CalendarViewHolder(cellBinding)
    }


    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        daysOfMonth?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount() = daysOfMonth?.size ?: 0
}