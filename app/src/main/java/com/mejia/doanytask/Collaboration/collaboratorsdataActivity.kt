package com.mejia.doanytask.Collaboration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.activity_collabopeople.*
import kotlinx.android.synthetic.main.activity_collaborators.*
import kotlinx.android.synthetic.main.viewcollaborators.view.*

class collaboratorsdataActivity : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootViewCollaboPeopleActivity: View = inflater.inflate(R.layout.viewcollaborators, container, false)

        rootViewCollaboPeopleActivity.submitbutton.setOnClickListener{
            dismiss()
        }
        return rootViewCollaboPeopleActivity
    }
}