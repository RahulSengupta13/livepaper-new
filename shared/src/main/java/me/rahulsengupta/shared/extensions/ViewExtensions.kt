package me.rahulsengupta.shared.extensions

import android.annotation.SuppressLint
import androidx.core.os.BuildCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.radiobutton.MaterialRadioButton

@SuppressLint("NewApi") // Lint does not understand isAtLeastQ currently
fun DrawerLayout.shouldCloseDrawerFromBackPress(): Boolean {
    if (BuildCompat.isAtLeastQ()) {
        // If we're running on Q, and this call to closeDrawers is from a key event
        // (for back handling), we should only honor it IF the device is not currently
        // in gesture mode. We approximate that by checking the system gesture insets
        return rootWindowInsets?.let {
            val systemGestureInsets = it.systemGestureInsets
            return systemGestureInsets.left == 0 && systemGestureInsets.right == 0
        } ?: false
    }
    // On P and earlier, always close the drawer
    return true
}

fun MaterialRadioButton.setOnCheckedListener(body: ()-> Unit) {
    setOnCheckedChangeListener { _, isChecked ->
        if(isChecked) body()
    }
}