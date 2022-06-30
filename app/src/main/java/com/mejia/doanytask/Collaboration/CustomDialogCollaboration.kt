package com.mejia.doanytask.Collaboration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.activity_collabopeople.view.*
import kotlinx.android.synthetic.main.collabform.view.*


class CustomDialogCollaboration : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootViewCollaboration: View = inflater.inflate(R.layout.viewcollaboration, container, false)

        rootViewCollaboration.submitbutton.setOnClickListener{
            dismiss()
        }

        return rootViewCollaboration
    }

}
