package com.mejia.doanytask

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mejia.doanytask.databinding.ActivityMainBinding.inflate
import com.mejia.doanytask.databinding.ItemActivityBinding.inflate
import kotlinx.android.synthetic.main.fragment_activity_collaboration.*


class ActivityCollaborationFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity_collaboration, container, false)

        val view: View = inflater!!.inflate(R.layout.fragment_collabo_people, container, false)

        button_colActive.setOnClickListener { view ->
            Log.d("button_colActive", "selected")
        }

        return view
    }
}

