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
import com.mejia.doanytask.databinding.FragmentMonthBinding
import java.time.LocalDate

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
}