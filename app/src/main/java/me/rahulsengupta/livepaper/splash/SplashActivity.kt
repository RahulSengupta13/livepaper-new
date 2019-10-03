package me.rahulsengupta.livepaper.splash

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import me.rahulsengupta.livepaper.R
import me.rahulsengupta.shared.ui.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun registerToolbarWithNavigation(toolbar: Toolbar) = Unit

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.root_nav_host_fragment).navigateUp() || super.onSupportNavigateUp()
    }
}
