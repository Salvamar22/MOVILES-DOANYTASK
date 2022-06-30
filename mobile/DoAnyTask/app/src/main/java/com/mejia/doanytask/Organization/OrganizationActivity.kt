package com.mejia.doanytask.Organization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mejia.doanytask.R
import kotlinx.android.synthetic.main.activity_organization.*

class OrganizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organization)

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
    }
}