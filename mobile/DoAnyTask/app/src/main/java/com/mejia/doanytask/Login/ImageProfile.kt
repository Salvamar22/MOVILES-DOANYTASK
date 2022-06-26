package com.mejia.doanytask.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.imageprofile.*
import kotlinx.android.synthetic.main.imageprofile.view.*

class ImageProfile : DialogFragment()  {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var addAvatar : View = inflater.inflate(R.layout.imageprofile, container, false)
       addAvatar.submit_button.setOnClickListener{
           dismiss()
       }
    return addAvatar
    }



}