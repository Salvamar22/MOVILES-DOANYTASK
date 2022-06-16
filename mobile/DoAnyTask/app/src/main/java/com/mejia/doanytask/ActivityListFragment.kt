package com.mejia.doanytask

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mejia.doanytask.databinding.FragmentActivityListBinding
import com.mejia.doanytask.databinding.ItemActivity2Binding
import com.mejia.doanytask.databinding.ItemActivityBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ActivityListFragment : Fragment() {

    private lateinit var binding: FragmentActivityListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_activity_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val acts = List<Activity>(6) { it ->
            Activity(
                "Evaluación práctica ${it + 1}.\n" +
                        "Uca. Presentacion\n" +
                        "Diseño App",
                "alta",
                LocalDateTime.of(2022, it + 2, 5, 14, 30)
            )
        }

        val activityRecyclerView = binding.activityListRecyclerView
        val activityAdapter = ActivityAdapter()
        activityRecyclerView.apply {
            adapter = activityAdapter
        }
        activityAdapter.setData(acts, 1)
    }
}

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
                binding.textDate.text = activity.getDate()
                binding.executePendingBindings()}

        }

        inner class ActivityViewHolder2(private val binding: ItemActivity2Binding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(activity: Activity) {
                binding.activity = activity
                binding.textHour.text = activity.getHour()
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
