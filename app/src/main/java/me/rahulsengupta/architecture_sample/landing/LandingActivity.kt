package me.rahulsengupta.architecture_sample.landing

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import me.rahulsengupta.architecture_sample.R
import me.rahulsengupta.shared.extensions.shouldCloseDrawerFromBackPress
import me.rahulsengupta.shared.navigation.NavigationFragment
import me.rahulsengupta.shared.ui.BaseActivity
import me.rahulsengupta.utils.navigationItemBackground

class LandingActivity : BaseActivity() {

    companion object {
        private val TOP_LEVEL_DESTINATIONS = setOf(
            me.rahulsengupta.home.R.id.navigation_homeFragment
        )
    }

    private lateinit var content: FrameLayout
    private lateinit var drawer: DrawerLayout
    private lateinit var navigation: NavigationView
    private lateinit var navController: NavController
    private var navHostFragment: NavHostFragment? = null
    private var currentNavId = R.id.navigation_homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        content = findViewById(R.id.content_container)
        content.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        drawer = findViewById(R.id.drawer)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.landing_nav_host_fragment) as NavHostFragment?

        navController = findNavController(R.id.landing_nav_host_fragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentNavId = destination.id
            val isTopLevelDestination = TOP_LEVEL_DESTINATIONS.contains(destination.id)
            val lockMode = if (isTopLevelDestination) {
                DrawerLayout.LOCK_MODE_UNLOCKED
            } else {
                DrawerLayout.LOCK_MODE_LOCKED_CLOSED
            }
            drawer.setDrawerLockMode(lockMode)
        }

        navigation = findViewById(R.id.navigation)
        navigation.apply {
            itemBackground = navigationItemBackground(this@LandingActivity)
            setupWithNavController(navController)
            setCheckedItem(currentNavId)
            setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_settingsFragment -> {
                        val uri = Uri.parse(getString(R.string.navigation_settingsFragment_deepLink))
                        navController.navigate(uri)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun registerToolbarWithNavigation(toolbar: Toolbar) {
        val appBarConfiguration = AppBarConfiguration(TOP_LEVEL_DESTINATIONS, drawer)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(navigation) && drawer.shouldCloseDrawerFromBackPress()) {
            closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        getCurrentFragment()?.onUserInteraction()
    }

    private fun getCurrentFragment(): NavigationFragment? {
        return navHostFragment
            ?.childFragmentManager
            ?.primaryNavigationFragment as? NavigationFragment
    }

    private fun closeDrawer() {
        drawer.closeDrawer(GravityCompat.START)
    }

    private fun navigateTo(navId: Int) {
        if (navId == currentNavId) {
            return // user tapped the current item
        }
        navController.navigate(navId)
    }
}
