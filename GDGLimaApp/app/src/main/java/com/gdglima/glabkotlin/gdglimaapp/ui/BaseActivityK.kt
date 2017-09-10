package com.gdglima.glabkotlin.gdglimaapp.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.gdglima.glabkotlin.gdglimaapp.BuildConfig

/**
 * Created by emedinaa on 2/09/17.
 */
open abstract class BaseActivityK : AppCompatActivity() {

    //abstract fun startViewsAnimation()
    //abstract fun endViewsAnimation()

    fun disabledDefaultAnimation(){
        overridePendingTransition(0,0)
    }


    fun log(lambda: () -> String) {
        if (BuildConfig.DEBUG) {
            Log.d("TAG", lambda())
        }
    }

    fun nextActivity(intent: Intent, destroy:Boolean=false){
        startActivity(intent)
        if(destroy) finish()
    }

    fun toast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}