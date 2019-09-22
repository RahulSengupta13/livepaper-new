package me.rahulsengupta.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_settings.*
import me.rahulsengupta.settings.R
import me.rahulsengupta.settings.SettingsFragmentAvm
import me.rahulsengupta.shared.extensions.navigateSafe
import me.rahulsengupta.shared.navigation.NavigationFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : NavigationFragment() {

    private val avm by viewModel<SettingsFragmentAvm>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settings_theme.setOnClickListener {
            findNavController().navigateSafe(R.id.action_settingsFragment_to_themeDialogFragment)
        }

        avm.setup()
    }
}
