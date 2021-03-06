package com.mejia.doanytask

import android.content.Intent
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
import com.mejia.doanytask.login.LoginActivity

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
    val app by lazy {
        application as DoAnyTaskApplication
    }

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
                app.saveAuthToken("")
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            R.id.monthlyFragment, R.id.activityListFragment -> {
                if (item.itemId != navController.currentDestination?.id) {
                    val handle = NavigationUI.onNavDestinationSelected(item, navController)
                    drawerLayout.close()
                    handle

                } else {
                    drawerLayout.close()
                    navController.navigate(R.id.activityListFragment)
                }
                true
            }
            else -> {
                if (item.itemId != navController.currentDestination?.id) {
                    this.supportActionBar!!.setCustomView(null);
                    val handle = NavigationUI.onNavDestinationSelected(item, navController)
                    drawerLayout.close()
                    handle

                } else {
                    drawerLayout.close()
                    navController.navigate(R.id.activityListFragment)
                }
                true
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
        goToDestination(R.id.acitivityEventFragment, view)
    }

    //task
    fun actionAddTask(view: View) {
        goToDestination(R.id.activityAddTaskFragment, view)
    }

    //Organization Pomodoro
    fun actionViewPomodoro(view: View) {
        goToDestination(R.id.activityOrganizationFragment, view)
    }

    //Organization Kanban
    fun actionViewKanban(view: View) {
        goToDestination(R.id.activityOrganizationFragment, view)
    }

    //Organization Gtd
    fun actionViewGtd(view: View) {
        goToDestination(R.id.activityOrganizationFragment, view)
    }

    //Function Collaborators Active
    fun collaboratorsactive(view: View) {
        goToDestination(R.id.activityCollaborationFragment, view)
    }

    //Function People Collaborators
    fun collaboratorspeople(view: View){
        goToDestination(R.id.activityCollaborationFragment, view)
    }

    // Search Collaborators
    fun searchcollaborators(view: View) {
        goToDestination(R.id.activityCollaborationFragment, view)
    }

    // Contacts
    fun contactscollaborators(view: View) {
        goToDestination(R.id.collaborationSearchFragment, view)
    }

    //Collaborators add
    fun dialogcollaborators(view: View) {
        goToDestination(R.id.registrationEventFragment, view)
    }

    private fun actionDateActivityBar(id: Int, button: View) {
        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.activityListFragment)
        }
    }

    private fun goToDestination(id: Int, button: View) {
        val apo: ActionBar =this.supportActionBar!!;
        apo.setCustomView(null);

        if (id != navController.currentDestination?.id) {
            navController.navigate(id)
        } else {
            navController.navigate(R.id.dialogPomodoroFragment)
        }
    }

}