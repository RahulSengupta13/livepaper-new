package me.rahulsengupta.architecture_sample.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.rahulsengupta.architecture_sample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val avm: MainActivityAvm by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        avm.setup()
    }
}
