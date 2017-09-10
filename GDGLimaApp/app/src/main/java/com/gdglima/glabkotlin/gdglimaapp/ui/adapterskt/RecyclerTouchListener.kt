package com.gdglima.glabkotlin.gdglimaapp.ui.listener

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

/**
 * Created by emedinaa on 14/10/15.
 */
open class RecyclerTouchListener(context: Context, recyclerView: RecyclerView, private val recyclerClickListener: RecyclerClickListener?) : RecyclerView.OnItemTouchListener {

    private val gestureDetector: GestureDetector

    init {

        gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                val child = recyclerView.findChildViewUnder(e.x, e.y)
                if (child != null && recyclerClickListener != null) {
                    recyclerClickListener.onLongClick(child, recyclerView.getChildPosition(child))
                }
            }
        })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x, e.y)
        if (child != null && recyclerClickListener != null && gestureDetector.onTouchEvent(e)) {
            recyclerClickListener.onClick(child, rv.getChildPosition(child))
        }

        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }


}

