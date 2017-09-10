package com.gdglima.glabkotlin.gdglimaapp.helpers

import android.view.View
import android.view.ViewGroup
import android.view.animation.*

/**
 * Created by emedinaa on 10/09/17.
 */

fun slideDown(view: View) {

    view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val targetHeight = view.measuredHeight
    view.layoutParams.height = 1
    view.visibility = View.VISIBLE

    val animation: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            view.layoutParams.height = if (interpolatedTime.toInt() === 1) ViewGroup.LayoutParams.WRAP_CONTENT else targetHeight * interpolatedTime.toInt()
            view.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }
    val dps: Int = targetHeight / view.context.resources.displayMetrics.density.toInt()
    animation.interpolator = AccelerateDecelerateInterpolator()
    animation.duration = 4 * dps.toLong()

    view.startAnimation(animation)
}

fun slideUp(view: View) {
    val initialHeight = view.measuredHeight
    val animation: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            if (interpolatedTime.toInt() == 1) {
                view.visibility = View.GONE
            } else {
                view.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                view.requestLayout();
            }
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }
    val dps: Int = initialHeight / view.context.resources.displayMetrics.density.toInt()
    animation.interpolator = AccelerateInterpolator()
    animation.duration = 4 * dps.toLong()

    view.startAnimation(animation)
}

fun fadeIn(view:View, duration:Long=500,delay:Long=200){
    val animation= AlphaAnimation(0.0f,1.0f)
    animation.interpolator=BounceInterpolator()
    animation.duration=duration
    animation.startOffset=delay
    view.startAnimation(animation)
}



