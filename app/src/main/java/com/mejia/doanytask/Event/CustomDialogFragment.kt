package com.mejia.doanytask.Event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.collabform.view.*

class CustomDialogFragment : DialogFragment() {

  override fun onCreateView(
   inflater: LayoutInflater,
   container: ViewGroup?,
   savedInstanceState: Bundle?
  ): View? {
   var rootView: View = inflater.inflate(R.layout.collabform, container, false)

      rootView.submitbutton.setOnClickListener{
        dismiss()
      }

      return rootView
  }

}