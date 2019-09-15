package me.rahulsengupta.architecture_sample.splash

import android.os.Bundle
import me.rahulsengupta.architecture_sample.R
import me.rahulsengupta.shared.ui.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
