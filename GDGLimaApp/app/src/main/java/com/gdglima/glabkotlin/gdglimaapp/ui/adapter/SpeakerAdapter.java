package com.gdglima.glabkotlin.gdglimaapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gdglima.glabkotlin.gdglimaapp.R;
import com.gdglima.glabkotlin.gdglimaapp.model.Speaker;

import java.util.List;

/**
 * Created by emedinaa on 16/09/17.
 */

public class SpeakerAdapter  extends RecyclerView.Adapter<SpeakerAdapter.ViewHolder>{

    private List<Speaker> speakers;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewName;
        public TextView textViewCountry;
        public TextView textViewBio;
        public ImageView imageViewContact;

        public ViewHolder(View v) {
            super(v);
            textViewName = v.findViewById(R.id.textViewName);
            textViewCountry = v.findViewById(R.id.textViewCountry);
            textViewBio = v.findViewById(R.id.textViewBio);
            imageViewContact = v.findViewById(R.id.imageViewContact);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_speaker, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Speaker speaker= speakers.get(position);
        if(speaker!=null){

            holder.textViewName.setText(speaker.getName());
            holder.textViewCountry.setText(speaker.getCountry());
            holder.textViewBio.setText(speaker.getBio());

            Glide.with(holder.imageViewContact.getContext())
                    .load(speaker.getImage())
                    .into(holder.imageViewContact);
        }

    }

    @Override
    public int getItemCount() {
        return speakers.size();
    }

}
