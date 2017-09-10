package com.gdglima.glabkotlin.gdglimaapp.ui.listener

import android.view.View

/**
 * Created by emedinaa on 14/10/15.
 */
interface RecyclerClickListener {
    fun onClick(view: View, position: Int)

    fun onLongClick(view: View, position: Int)
}