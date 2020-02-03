package com.example.hangio.ui.attendingevents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttendingEventsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ATTENDING EVENTS Fragment"
    }
    val text: LiveData<String> = _text
}