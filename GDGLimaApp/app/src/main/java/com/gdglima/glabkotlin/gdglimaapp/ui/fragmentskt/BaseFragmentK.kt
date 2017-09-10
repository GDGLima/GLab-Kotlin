package com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt

import android.support.v4.app.Fragment
import android.util.Log
import com.gdglima.glabkotlin.gdglimaapp.BuildConfig
import retrofit2.Call

/**
 * Created by emedinaa on 3/09/17.
 */
open abstract class BaseFragmentK<T>:Fragment() {

    protected var currentCall:Call<T>?=null;

    fun log(lambda: () -> String) {
        if (BuildConfig.DEBUG) {
            Log.d("TAG", lambda())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //currentCall!!.cancel()
    }

    override fun onStop() {
        super.onStop()
        currentCall!!.cancel()
    }

    abstract fun showLoading()
    abstract fun hideLoading()
}