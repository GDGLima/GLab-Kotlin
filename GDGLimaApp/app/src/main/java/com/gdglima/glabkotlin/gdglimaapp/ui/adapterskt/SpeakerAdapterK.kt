package com.gdglima.glabkotlin.gdglimaapp.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.model.EntityK
import kotlinx.android.synthetic.main.row_speaker.view.*

/**
 * Created by emedinaa on 06/04/17.
 */
class SpeakerAdapterK(val speakers:List<EntityK.SpeakerK>, val context:Context): RecyclerView.Adapter<SpeakerAdapterK.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.textViewName
        val textViewCountry: TextView = view.textViewCountry
        val textViewBio: TextView = view.textViewBio
        val imageViewContact: ImageView = view.imageViewContact
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.row_speaker, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val fullName: String = speakers[position].title
        val country: String = speakers[position].country
        val image:String = speakers[position].image
        val bio: String? = speakers[position].bio

        holder.textViewName.text = fullName
        holder.textViewCountry.text = country
        holder.textViewBio.text = bio

        Glide.with(holder.imageViewContact.context)
                .load(image).into(holder.imageViewContact);
    }

    override fun getItemCount(): Int {
        return speakers.size
    }

}