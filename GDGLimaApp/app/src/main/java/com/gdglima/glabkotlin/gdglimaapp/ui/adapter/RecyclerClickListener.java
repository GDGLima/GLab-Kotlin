package com.gdglima.glabkotlin.gdglimaapp.ui.adapter;

import android.view.View;

/**
 * Created by emedinaa on 14/10/15.
 */
public interface RecyclerClickListener {
    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}