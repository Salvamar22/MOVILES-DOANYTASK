package com.mejia.doanytask.Organization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.viewdateorgani.view.*

class CustomDialogOrganization : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootViewOrganization: View = inflater.inflate(R.layout.viewdateorgani, container, false )
        rootViewOrganization.submitbutton.setOnClickListener {
            dismiss()
        }

        return rootViewOrganization
    }
}