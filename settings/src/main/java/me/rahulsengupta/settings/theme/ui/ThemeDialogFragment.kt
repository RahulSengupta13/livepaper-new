package me.rahulsengupta.settings.theme.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import me.rahulsengupta.settings.R
import me.rahulsengupta.settings.theme.ThemeDialogAvm
import me.rahulsengupta.shared.theme.Theme
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThemeDialogFragment: DialogFragment(), ThemeDialogPresenter.Listener {

    private val avm by viewModel<ThemeDialogAvm>()
    private lateinit var presenterContainer: ThemeDialogPresenter.Container

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =  inflater.inflate(R.layout.dialog_theme, container, false)
        presenterContainer = ThemeDialogPresenter.Container(root, this)
        isCancelable = false
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        avm.present.observe(viewLifecycleOwner, Observer {
            ThemeDialogPresenter.present(presenterContainer, it)
        })
        avm.finish.observe(viewLifecycleOwner, Observer {
            dismiss()
        })

        avm.setup()
    }

    override fun onApplyClicked() = avm.onApplyClicked()
    override fun onCancelClicked() = avm.onCancelClicked()
    override fun onRadioClicked(theme: Theme) = avm.onRadioClicked(theme)
}