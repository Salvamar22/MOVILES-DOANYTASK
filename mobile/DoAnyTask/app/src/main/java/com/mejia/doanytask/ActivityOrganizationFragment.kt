package com.mejia.doanytask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mejia.doanytask.Organization.CustomDialogOrganiKanban
import com.mejia.doanytask.Organization.CustomDialogOrganigtd
import com.mejia.doanytask.Organization.CustomDialogOrganization


class ActivityOrganizationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity_organization, container, false)
    }
/*
    button_organization.setOnClickListener {
        val dialog = CustomDialogOrganization()

        dialog.show(supportFragmentManager, "customDialog")
    }

    button_kanban.setOnClickListener {
        val dialogorgani = CustomDialogOrganiKanban()

        dialogorgani.show(supportFragmentManager, "customDialog")
    }

    button_gtd.setOnClickListener {
        val dialoggtd = CustomDialogOrganigtd()
        dialoggtd.show(supportFragmentManager, "customDialog")
    }

 */
}
