package com.mejia.doanytask

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_acitivity_event.*
import kotlinx.android.synthetic.main.fragment_activity_organization.*
import kotlinx.android.synthetic.main.fragment_activity_task.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNavView: BottomNavigationView
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpNavigation()
        setupNavigationView()
    }

    private fun setUpNavigation() {
        val toolBar: Toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolBar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        drawerLayout = findViewById(R.id.main_drawer_Layout)
        navController = navHostFragment.navController
        drawerLayout = findViewById(R.id.main_drawer_Layout)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                // TODO agregar los demas fragmentos donde se debe mostrar menu de hamburguesa
                R.id.main_drawer_Layout,
                R.id.monthlyFragment,
                R.id.activityListFragment,
                R.id.weeklyFragment,
                R.id.dailyFragment
            ),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        toolBar.navigationIcon!!.setColorFilter(
            resources.getColor(R.color.black),
            PorterDuff.Mode.MULTIPLY
        )
        this.supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.setCustomView(R.layout.date_app_bar)
    }

    private fun setupNavigationView() {
        navigationView = findViewById(R.id.nav_view)
        bottomNavView = findViewById(R.id.bottom_nav_view)
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener(this)
        bottomNavView.setOnItemSelectedListener(this)
        fillNavigationView()
    }

    private fun fillNavigationView() {
        navigationView.menu.clear()
        navigationView.inflateMenu(R.menu.main_menu)
        MenuCompat.setGroupDividerEnabled(navigationView.menu, true);

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                // TODO
                true
            }
            else -> {
                val handle = NavigationUI.onNavDestinationSelected(item, navController)
                drawerLayout.close()
                handle
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun actionToMonthly(view: View) {
        val id = View.generateViewId()
        actionDateActivityBar(R.id.monthlyFragment, view)
    }

    fun actionToWeekly(view: View) {
        actionDateActivityBar(R.id.weeklyFragment, view)
    }

    fun actionToDaily(view: View) {
        actionDateActivityBar(R.id.dailyFragment, view)
    }

    //Event
    fun actionEventadd(view: View) {
        action_event(R.id.acitivityEventFragment, view)
    }

    //task
    fun actionAddTask(view: View) {
        action_add(R.id.activityAddTaskFragment, view)
    }

    //Organization Pomodoro
    fun actionViewPomodoro(view: View) {
        button_pomodoro(R.id.activityOrganizationFragment, view)
    }

    //Organization Kanban
    fun actionViewKanban(view: View) {
        button_kanban(R.id.activityOrganizationFragment, view)
    }

    //Organization Gtd
    fun actionViewGtd(view: View) {
        button_gtd(R.id.activityOrganizationFragment, view)
    }

    //Function Collaborators Active
    fun collaboratorsactive(view: View) {
        button_colActive(R.id.activityCollaborationFragment, view)
    }

    //Function People Collaborators
    fun collaboratorspeople(view: View){
        button_collabo(R.id.activityCollaborationFragment, view)
    }

    // Search Collaborators
    fun searchcollaborators(view: View) {
        button_search(R.id.activityCollaborationFragment, view)
    }

    // Contacts
    fun contactscollaborators(view: View) {
        button_contact(R.id.collaborationSearchFragment, view)
    }

    //Collaborators add
    fun dialogcollaborators(view: View) {
        btnForm(R.id.registrationEventFragment, view)
    }

    private fun actionDateActivityBar(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.activityListFragment)
        }
    }

    //Functioon Event
    private fun action_event(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.registrationEventFragment)
        }
    }

    //Function Task
    private fun action_add(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.activityAddTaskFragment)
        }
    }


    //Function Pomodoro
    private fun button_pomodoro(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.dialogPomodoroFragment)
        }
    }

    //Function Kanban
    private fun button_kanban(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.dialogKanbanFragment)
        }
    }

    //Function Gtd
    private fun button_gtd(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.dialogGtdFragment)
        }
    }

    //Function Collabo Active
    private fun button_colActive(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.collaboPeopleFragment)
        }
    }

    //Function Collabo People
    private fun button_collabo(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.collaboratorsFragment)
        }
    }

    //Function Search Collaborators
    private fun button_search(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.collaborationSearchFragment)
        }
    }

    //Function Contacts Collaborators
    private fun button_contact(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.collaborationsContactsFragment)
        }
    }

    //Dialog Colaboratoros
    private fun btnForm(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.dialogCollaborationFragment)
        }
    }

}