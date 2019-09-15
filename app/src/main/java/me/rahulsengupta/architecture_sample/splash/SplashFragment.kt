package me.rahulsengupta.architecture_sample.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import me.rahulsengupta.architecture_sample.R
import me.rahulsengupta.shared.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment() {

    private val avm: SplashFragmentAvm by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        avm.finish.observe(this, Observer {
            Toast.makeText(context, "Loaded", Toast.LENGTH_SHORT).show()
        })

        avm.setup()
    }


}
