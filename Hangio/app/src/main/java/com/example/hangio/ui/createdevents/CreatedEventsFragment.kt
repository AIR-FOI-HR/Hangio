package com.example.hangio.ui.createdevents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hangio.R

class CreatedEventsFragment : Fragment() {

    private lateinit var createdEventsViewModel: CreatedEventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        createdEventsViewModel =
            ViewModelProviders.of(this).get(CreatedEventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_created_events, container, false)
        val textView: TextView = root.findViewById(R.id.text_created_events)
        createdEventsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}