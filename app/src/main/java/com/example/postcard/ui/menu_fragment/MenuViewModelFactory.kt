package com.example.postcard.ui.menu_fragment

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MenuViewModelFactory(
    private val activity: FragmentActivity?
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MenuViewModel(activity) as T
    }
}