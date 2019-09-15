package me.rahulsengupta.home

import android.os.Bundle
import androidx.navigation.findNavController
import me.rahulsengupta.shared.ui.BaseActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.home_nav_host_fragment).navigateUp() || super.onSupportNavigateUp()
    }
}
