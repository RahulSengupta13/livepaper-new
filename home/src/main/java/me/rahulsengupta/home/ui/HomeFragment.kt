package me.rahulsengupta.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import me.rahulsengupta.home.HomeFragmentAvm
import me.rahulsengupta.home.R
import me.rahulsengupta.shared.navigation.NavigationFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : NavigationFragment() {

    private val avm: HomeFragmentAvm by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        avm.present.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "Photos Downloaded: ${it.photos.size}", Toast.LENGTH_SHORT)
                .show()
        })

        avm.setup()
    }
}
