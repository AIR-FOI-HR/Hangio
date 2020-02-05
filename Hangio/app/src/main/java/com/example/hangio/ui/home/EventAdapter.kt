package com.example.hangio.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.db.data.entities.Event
import com.example.hangio.R

class EventAdapter(listener: OnItemSelected) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private val itemSelectedListener = listener
    private var data: List<Event>? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val titleTextView: TextView = view.findViewById(R.id.event_title)
        val address: TextView = view.findViewById(R.id.event_address)
        val locationTextView: TextView = view.findViewById(R.id.event_location)
        val timeTextView: TextView = view.findViewById(R.id.event_time)
        val attendantsTextView: TextView = view.findViewById(R.id.event_attendants)
        val infoButton: Button = view.findViewById(R.id.event_info)
        val attendButton: Button = view.findViewById(R.id.event_attend)
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
        holder.address.text = data!![position].address
        holder.locationTextView.text = data!![position].description
        holder.timeTextView.text = data!![position].startDate.toString()
        holder.attendantsTextView.text = data!![position].capacity.toString()

        holder.infoButton.setOnClickListener{
            itemSelectedListener.selectedInfo(data!![position])
        }

        holder.attendButton.setOnClickListener{
            itemSelectedListener.selectedAttend(data!![position])
        }
    }

    public fun setData(data: List<Event>){
        this.data = data
        notifyDataSetChanged()
    }

    public interface OnItemSelected{
        fun selectedInfo(event: Event)
        fun selectedAttend(event: Event)
    }
}