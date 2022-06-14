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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_activity_list, container, false)
        return binding.root
    }
}