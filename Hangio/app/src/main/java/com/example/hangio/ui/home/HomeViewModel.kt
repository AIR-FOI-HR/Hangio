package com.example.hangio.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ws.Event
import com.example.ws.ResponseHandler
import com.example.ws.WebServiceProvider

class HomeViewModel : ViewModel() {

    private val webServiceProvider = WebServiceProvider()
    private val _text = MutableLiveData<String>().apply {
        value = "This is HOME Fragment"
    }
    val text: LiveData<String> = _text

    private val _events = MutableLiveData<List<Event>>().apply {
        webServiceProvider.getEvents(object : ResponseHandler {
            override fun onData(data: Any) {
                value = data as List<Event>
            }
        })
    }
    val events = _events

}