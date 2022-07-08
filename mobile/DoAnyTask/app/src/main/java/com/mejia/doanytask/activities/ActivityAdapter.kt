package com.mejia.doanytask.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mejia.doanytask.R
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.databinding.ItemActivity2Binding
import com.mejia.doanytask.databinding.ItemActivityBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
/*

data class Activity (
    val description: String,
    val priority: String,
    val date: LocalDateTime
) {
    public fun getHour(): String {
        return date.format(DateTimeFormatter.ofPattern("hh:mm"))
    }
    public fun getDate(): String {
        return date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
    }
}
*/
open class ActivityAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_TYPE_DEFAULT = 0
    private val ITEM_TYPE_ALTERNATIVE = 1

    private var activityList: List<Activity>? = null
    private var typeItem: Int = ITEM_TYPE_DEFAULT

    fun setData(data: List<Activity>, type: Int = ITEM_TYPE_DEFAULT) {
        this.activityList = data
        typeItem = type
        notifyDataSetChanged()
    }

    inner class ActivityViewHolder(private val binding: ItemActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: Activity) {
            binding.activity = activity
            //binding.textHour.text = activity.getHour()
            binding.textDate.text = activity.date
            binding.executePendingBindings()}

    }

    inner class ActivityViewHolder2(private val binding: ItemActivity2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: Activity) {
            binding.activity = activity
            binding.textHour.text = activity.hour
            binding.activityDayWeek.text = activity.date.format(DateTimeFormatter.ofPattern("dd"))
            binding.activityMonth.text = activity.date.format(DateTimeFormatter.ofPattern("MMM"))
            binding.activityDayMonth.text = activity.date.format(DateTimeFormatter.ofPattern("dd"))
            binding.executePendingBindings()}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when(typeItem) {
            ITEM_TYPE_ALTERNATIVE -> {
                ActivityViewHolder2(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_activity2,
                        parent,
                        false
                    )
                )
            }
            else -> {
                ActivityViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_activity,
                        parent,
                        false
                    )
                )
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        activityList?.let {
            when(typeItem) {
                ITEM_TYPE_ALTERNATIVE -> (holder as ActivityViewHolder2).bind(it[position])
                else -> (holder as ActivityViewHolder).bind(it[position])
            }
        }
    }

    override fun getItemCount() = activityList?.size ?: 0
}