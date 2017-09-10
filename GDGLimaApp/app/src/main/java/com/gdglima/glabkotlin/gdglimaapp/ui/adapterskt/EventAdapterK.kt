package com.gdglima.glabkotlin.gdglimaapp.ui.adapterskt

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.helpers.formatDate
import com.gdglima.glabkotlin.gdglimaapp.model.EntityK
import kotlinx.android.synthetic.main.row_event.view.*

/**
 * Created by emedinaa on 3/09/17.
 */
class EventAdapterK(val events:List<EntityK.EventK>, val context: Context): RecyclerView.Adapter<EventAdapterK.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewHour: TextView = view.textViewHour
        val textViewTitle: TextView = view.textViewTitle
        val textSpeaker: TextView = view.textSpeaker
        val textViewDate: TextView = view.textViewDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.row_event, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val title: String = events[position].titulo!!
        val sb = StringBuilder()
        sb.append(events[position].horario_inicio).append("-").append(events[position].horario_fin)
        val hour: String? = sb.toString()
        val speaker:String=events[position].expositor_nombre
        val date:String =events[position].fecha

        holder.textViewHour.text = hour
        holder.textViewTitle.text = title
        holder.textSpeaker.text = speaker
        holder.textViewDate.text = formatDate(date)
    }

    override fun getItemCount(): Int {
        return events.size
    }
}