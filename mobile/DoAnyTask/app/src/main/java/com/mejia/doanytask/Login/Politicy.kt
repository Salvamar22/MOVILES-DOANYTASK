package com.mejia.doanytask.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.imageprofile.view.*
import kotlinx.android.synthetic.main.politicy.view.*

class Politicy: DialogFragment()  {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var politicytext : View = inflater.inflate(R.layout.politicy, container, false)
        politicytext.accept.setOnClickListener{
            dismiss()
        }
        return politicytext
    }



}