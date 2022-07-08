package com.mejia.doanytask.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mejia.doanytask.MainActivity
import com.mejia.doanytask.R
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.databinding.FragmentActivityListBinding
import java.time.LocalDateTime

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

                it.toString(),
                "Evaluación práctica ${it + 1}.\n" ,
                "Alta",
                "Uca.",
                "2022/" + it + 2 + "/5",
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
        activityAdapter.setData(acts, 0)
        setActionBar()
    }

    private fun setActionBar() {
        val dateBar: View = getLayoutInflater().inflate(R.layout.date_app_bar, null)

        val apo: ActionBar =(activity as MainActivity).supportActionBar!!
        apo.setCustomView(dateBar)
    }
}

