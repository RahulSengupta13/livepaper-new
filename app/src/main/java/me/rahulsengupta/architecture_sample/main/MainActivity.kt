package me.rahulsengupta.architecture_sample.main

import android.os.Bundle
import me.rahulsengupta.architecture_sample.R
import me.rahulsengupta.shared.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val avm: MainActivityAvm by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        avm.setup()
    }
}
