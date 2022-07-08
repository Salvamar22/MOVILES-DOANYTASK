package com.mejia.doanytask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class CollaboPeopleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_collabo_people, container, false)
        val buttonPrev : Button = view.findViewById(R.id.button_tray)
        buttonPrev.setOnClickListener {
            val fragment = ActivityCollaborationFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.main_drawer_Layout, fragment)?.commit()
        }
        return view
    }

}