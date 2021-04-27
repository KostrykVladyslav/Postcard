package com.example.postcard.ui.menu_fragment.binding_adapter

import androidx.databinding.BindingAdapter
import com.example.postcard.R
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorMassage")
fun TextInputLayout.errorMessage(errorState: Boolean){
    error = if (errorState){
        context.getString(R.string.field_is_empty)
    } else ""
}