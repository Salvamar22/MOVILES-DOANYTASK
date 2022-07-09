package com.mejia.doanytask.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mejia.doanytask.DoAnyTaskApplication
import com.mejia.doanytask.MainActivity
import com.mejia.doanytask.R
import com.mejia.doanytask.ViewModelFactory
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.databinding.FragmentActivityListBinding
import com.mejia.doanytask.login.LoginViewModel
import java.time.LocalDateTime

class ActivityListFragment : Fragment() {
    val app by lazy {
        activity?.application as DoAnyTaskApplication
    }

    private lateinit var binding: FragmentActivityListBinding

    private val viewModelFactory by lazy {
        ViewModelFactory(app.getActivityRepository())
    }
    private val viewModel: ActivitiesViewModel by viewModels {
        viewModelFactory
    }

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

        setActionBar()
        /*val acts = List<Activity>(6) { it ->
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
        }*/

        val activityRecyclerView = binding.activityListRecyclerView
        val activityAdapter = ActivityAdapter()
        activityRecyclerView.apply {
            adapter = activityAdapter
        }
        viewModel.getAllActivitys()

        viewModel.status.observe(viewLifecycleOwner) { status ->
            when (status) {
                is ActivityUiState.Error -> Log.d("Activity List Status", "Error", status.exception)
                ActivityUiState.Loading -> Log.d("Activity List Status", "Loading")
                is ActivityUiState.Success -> handleSuccess(status, activityAdapter, null)
            }
        }
    }

    private fun setActionBar() {
        val dateBar: View = getLayoutInflater().inflate(R.layout.date_app_bar, null)

        val apo: ActionBar =(activity as MainActivity).supportActionBar!!
        apo.setCustomView(dateBar)
    }

    private fun handleSuccess(status: ActivityUiState.Success, ActivityAdapter: ActivityAdapter, pBar: ProgressBar?) {
        status.activities.observe(viewLifecycleOwner) { data ->
            ActivityAdapter.setData(data, 0)
        }
        if(pBar != null)
            pBar?.setVisibility(View.GONE)
    }
}

