package com.example.hangio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hangio.R
import com.example.ws.Event
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),EventAdapter.OnItemSelected {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.adapter = EventAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
     //   val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
      //      textView.text = it
        })
        homeViewModel.events.observe(this, Observer{
            adapter.setData(it)
        })
            return root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    override fun selectedItem(event: Event) {
        Toast.makeText(requireContext(),event.title,Toast.LENGTH_SHORT).show()
    }
}
