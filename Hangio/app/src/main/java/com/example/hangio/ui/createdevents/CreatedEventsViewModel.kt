package com.example.hangio.ui.createdevents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreatedEventsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is MY EVENTS Fragment"
    }
    val text: LiveData<String> = _text
}