package com.example.postcard.ui.menu_fragment

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class MenuModel(
    var _name: String = "",
    var _title: String = "",
    var _description: String = ""
) : BaseObservable(), Parcelable {

    @IgnoredOnParcel
    @get:Bindable
    var name: String = _name
        set(value) {
            _name = value
            field = value
        }

    @IgnoredOnParcel
    @get:Bindable
    var title: String = _title
        set(value){
            _title = value
            field = value
        }

    @IgnoredOnParcel
    @get:Bindable
    var description: String = _description
        set(value){
            _description = value
            field = value
        }

    fun isError() = _name.isEmpty() || _title.isEmpty() || _description.isEmpty()
}