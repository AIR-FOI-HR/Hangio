package com.example.hangio.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hangio.R
import com.example.ws.Event

class EventAdapter(listener: OnItemSelected) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private val itemSelectedListener = listener
    private var data: List<Event>? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val titleTextView: TextView = view.findViewById(R.id.event_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_list_item, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = data!![position].title
        holder.itemView.setOnClickListener{
            itemSelectedListener.selectedItem(data!![position])
        }
    }

    public fun setData(data: List<Event>){
        this.data = data
        notifyDataSetChanged()
    }

    public interface OnItemSelected{
        fun selectedItem(event: Event)
    }
}