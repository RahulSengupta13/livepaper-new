package me.rahulsengupta.settings.theme.ui

import android.view.View
import android.widget.RadioGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.radiobutton.MaterialRadioButton
import kotlinx.android.synthetic.main.dialog_theme.view.*
import me.rahulsengupta.shared.theme.Theme
import me.rahulsengupta.shared.theme.Theme.*
import me.rahulsengupta.settings.theme.model.ThemeDialogViewModel
import me.rahulsengupta.shared.extensions.setOnCheckedListener

class ThemeDialogPresenter {

    class Container(val root: View, val listener: Listener) {
        val radioGroup: RadioGroup = root.theme_radio_group
        val radioLight: MaterialRadioButton = root.theme_radio_light
        val radioDark: MaterialRadioButton = root.theme_radio_dark
        val radioSystem: MaterialRadioButton = root.theme_radio_system
        private val buttonApply: MaterialButton = root.theme_dialog_apply
        private val buttonCancel: MaterialButton = root.theme_dialog_cancel

        init {
            radioLight.setOnCheckedListener { listener.onRadioClicked(LIGHT) }
            radioDark.setOnCheckedListener { listener.onRadioClicked(DARK) }
            radioSystem.setOnCheckedListener { listener.onRadioClicked(SYSTEM) }
            buttonApply.setOnClickListener { listener.onApplyClicked() }
            buttonCancel.setOnClickListener { listener.onCancelClicked() }
        }
    }

    companion object {

        fun present(container: Container, viewModel: ThemeDialogViewModel) {
            container.run {
                radioDark.isChecked = viewModel.darkChecked
                radioLight.isChecked = viewModel.lightChecked
                radioSystem.isChecked = viewModel.systemChecked
            }
        }
    }

    interface Listener {
        fun onRadioClicked(theme: Theme)
        fun onApplyClicked()
        fun onCancelClicked()
    }
}