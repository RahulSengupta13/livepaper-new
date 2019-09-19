package me.rahulsengupta.architecture_sample.splash

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import me.rahulsengupta.architecture_sample.R
import me.rahulsengupta.shared.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment() {

    private val avm: SplashFragmentAvm by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_splash, container, false)

        avm.finish.observe(viewLifecycleOwner, Observer {
            val uri = Uri.parse(getString(R.string.navigation_homeActivity_deepLink))
            findNavController().navigate(uri)
            activity?.finish()
        })

        avm.setup()

        return root
    }
}
