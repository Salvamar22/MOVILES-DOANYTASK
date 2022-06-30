package com.mejia.doanytask.Organization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.viewdateorgani.view.*

class CustomDialogOrganigtd  : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootViewGtd : View = inflater.inflate(R.layout.viewdategtd, container, false)
        rootViewGtd.submitbutton.setOnClickListener {
            dismiss()
        }
        return rootViewGtd
    }
}