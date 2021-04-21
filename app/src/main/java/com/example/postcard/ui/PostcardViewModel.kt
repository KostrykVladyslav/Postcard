package com.example.postcard.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.postcard.data.Postcard

class PostcardViewModel : ViewModel() {
    val postcard: MutableLiveData<Postcard> by lazy {
        MutableLiveData<Postcard>()
    }

    fun setValues(name: String, title: String, description: String) {
        postcard.value?.name = name
        postcard.value?.title = title
        postcard.value?.description = description
    }

    fun getName(): String {
        return postcard.value?.name?: ""
    }

    fun getTitle(): String {
        return postcard.value?.title?: ""
    }

    fun getDescription(): String {
        return postcard.value?.description?: ""
    }
}