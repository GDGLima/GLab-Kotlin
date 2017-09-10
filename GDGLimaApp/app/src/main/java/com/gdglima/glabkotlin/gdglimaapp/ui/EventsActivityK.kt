package com.gdglima.glabkotlin.gdglimaapp.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.data.model.EventResponseK
import com.gdglima.glabkotlin.gdglimaapp.data.storage.ApliClientK
import com.gdglima.glabkotlin.gdglimaapp.model.EntityK
import com.gdglima.glabkotlin.gdglimaapp.ui.adapterskt.EventAdapterK
import kotlinx.android.synthetic.main.activity_events.*
import kotlinx.android.synthetic.main.layout_progress.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Kotlin collections
 * https://kotlinlang.org/docs/reference/collections.html
 */
class EventsActivityK : BaseActivityK() {

    private var eventAdapter:EventAdapterK?=null
    private var currentView:TextView?=null

    val dates = listOf("2017/09/04", "2017/09/05", "2017/09/06","2017/09/07")
    var views:List<TextView> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        ui()

        requestFirst()
    }

    private fun requestFirst(){
        currentView=views[0]
        val date:String = dates[0]
        updateViewSelected()

        requestEvents(date)
    }

    private fun updateViewPrev(){
        currentView!!.setBackgroundColor(resources.getColor(android.R.color.white))
        currentView!!.setTextColor(resources.getColor(android.R.color.black))
    }

    private fun updateViewSelected()
    {
        currentView!!.setBackgroundColor(resources.getColor(R.color.greenGDGLima))
        currentView!!.setTextColor(resources.getColor(android.R.color.white))
    }

    private fun ui(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Programa"

        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerViewEvents.layoutManager= mLayoutManager

        views=listOf(textViewMon, textViewTue,textViewWed,textViewThu)

        //events
        views.forEach {
            it.setOnClickListener{
                if(currentView!=null){
                    updateViewPrev()
                }
                val date:String = dates[views.indexOf(it)]
                requestEvents(date)
                currentView= it as TextView
                updateViewSelected()
            }
        }
        /*for (i in arr.indices) {
            println(arr[i])
        }*/
    }

    private fun renderEvents(events:List<EntityK.EventK>){
        eventAdapter= EventAdapterK(events!!,this)
        recyclerViewEvents.setAdapter(eventAdapter!!)

    }

    //endpoints
    private val callback: Callback<EventResponseK> = object: Callback<EventResponseK> {
        override fun onResponse(call: Call<EventResponseK>?, response: Response<EventResponseK>?) {
            hideLoading()

            log({"onResponse $response.body()"})
            renderEvents(response!!.body()!!.data)
        }

        override fun onFailure(call: Call<EventResponseK>?, t: Throwable?) {
            if(!call!!.isCanceled){
                hideLoading()
            }
            log({"onFailure $t"})
        }
    }

    private fun requestEvents(date:String){
        showLoading()
        val call: Call<EventResponseK> = ApliClientK.getMyApiClient().events(date)
        call!!.enqueue(callback)
    }

    private fun showLoading(){
        relativeLayoutProgress.visibility= View.VISIBLE
    }

    private fun hideLoading(){
        relativeLayoutProgress.visibility= View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
