package com.example.hangio.ui.attendingevents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hangio.R

class AttendingEventsFragment : Fragment() {

    private lateinit var attendingEventsViewModel: AttendingEventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        attendingEventsViewModel =
            ViewModelProviders.of(this).get(AttendingEventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_attending_events, container, false)
        val textView: TextView = root.findViewById(R.id.text_attending_events)
        attendingEventsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}