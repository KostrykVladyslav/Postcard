package com.example.postcard.ui.menu_fragment

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.postcard.MainActivity

class MenuViewModel(
    @field:SuppressLint("StaticFieldLeak")
    private val activity: FragmentActivity?
) : ViewModel() {

    val model = MenuModel()

    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent

    private val _errorName = MutableLiveData<Boolean>()
    val errorName: LiveData<Boolean> = _errorName

    private val _errorTitle = MutableLiveData<Boolean>()
    val errorTitle: LiveData<Boolean> = _errorTitle

    private val _errorDescription = MutableLiveData<Boolean>()
    val errorDescription: LiveData<Boolean> = _errorDescription

    fun launchPostcardFragment(testing: Boolean) {
        model.apply {
            Log.d("LOG:", "Pressed $name $title $description")
            _errorName.value = name.isEmpty()
            _errorTitle.value = title.isEmpty()
            _errorDescription.value = description.isEmpty()

            if (!isError()) {
                if (testing) {
                    saveModelPreferences(model)
                    _navigationLiveEvent.value =
                        MenuFragmentDirections.actionMainFragmentToPostcardFragment()
                } else {
                    saveModelPreferences(model)
                    putBooleanCardLaunchPreferences(true)
                    (activity as MainActivity).finish()
                }
            }
        }
    }

    private fun saveModelPreferences(model: MenuModel) {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.putString("name", model.name)
        editor?.putString("title", model.title)
        editor?.putString("description", model.description)
        editor?.apply()
    }

    private fun putBooleanCardLaunchPreferences(postcardFragmentNextLaunch: Boolean) {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.putBoolean("second_fragment_launch", postcardFragmentNextLaunch)
        editor?.apply()
    }
}
