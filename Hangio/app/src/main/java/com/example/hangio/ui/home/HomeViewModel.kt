package com.example.hangio.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.db.data.AppDatabase
import com.example.db.data.entities.Event
import com.example.ws.ResponseHandler
import com.example.ws.WebServiceProvider
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Handler

class HomeViewModel : ViewModel() {

    var context: Context? = null
        set(value) {
            value
        }

    private val webServiceProvider = WebServiceProvider()
    private val _text = MutableLiveData<String>().apply {
        value = "This is HOME Fragment"
    }
    val text: LiveData<String> = _text

    private val _events = MutableLiveData<List<Event>>().apply {
        val db = AppDatabase.getInstance()

        android.os.Handler().post {
            var allEvents = db!!.EventDAO().getAllEvents()

            webServiceProvider.getEvents(object : ResponseHandler {
                override fun onData(data: Any) {
                    var formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

                    val newData = LinkedList<Event>()
                    for (event in data as List<com.example.ws.Event>) {
                        val entity = Event(
                            event.idevent,
                            event.title,
                            formatter.parse(event.start_date),
                            event.address,
                            event.description,
                            event.capacity,
                            event.registered,
                            event.creator_id,
                            event.city_id,
                            event.event_category_id
                        )
                        db.EventDAO().insertEvent(entity)
                        newData.add(entity)
                    }


                    if(allEvents != newData) {
                        value = newData
                    }
                    else{
                        value = allEvents
                    }
                    Log.i("HomeViewModel", "From WS")
                }
            })
        }
    }
    val events = _events
}