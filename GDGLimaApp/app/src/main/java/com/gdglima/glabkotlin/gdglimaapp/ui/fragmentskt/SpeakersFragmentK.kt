package com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.data.model.SpeakerResponseK
import com.gdglima.glabkotlin.gdglimaapp.data.storage.ApliClientK
import com.gdglima.glabkotlin.gdglimaapp.model.EntityK
import com.gdglima.glabkotlin.gdglimaapp.ui.adapters.SpeakerAdapterK
import kotlinx.android.synthetic.main.fragment_speakers.*
import kotlinx.android.synthetic.main.layout_progress.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by emedinaa on 2/09/17.
 */
class SpeakersFragmentK : BaseFragmentK<SpeakerResponseK>() {

    private var mParam1: String? = null
    private var mParam2: String? = null
    private var speakerAdapter: SpeakerAdapterK?=null

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): SpeakersFragmentK {
            var args: Bundle = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)

            var homeFragment: SpeakersFragmentK = newInstance()
            homeFragment.arguments = args
            return homeFragment
        }

        fun newInstance(): SpeakersFragmentK {
            return SpeakersFragmentK()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ui()
        requestSpeakers()
    }

    private fun ui(){
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!)
        recyclerViewSpeakers.layoutManager= mLayoutManager
    }

    private fun renderSpeakers(speakers:List<EntityK.SpeakerK>){
        if(activity!=null){
            speakerAdapter= SpeakerAdapterK(speakers,activity)
            recyclerViewSpeakers.setAdapter(speakerAdapter)
        }
    }

    private fun requestSpeakers(){
        showLoading()
        ApliClientK.getMyApiClient().speakers()
        //val call: Call<SpeakerResponseK> = ApliClientK.getMyApiClient().speakers()
        currentCall = ApliClientK.getMyApiClient().speakers()
        currentCall!!.enqueue(callback)
    }

    //endpoints
    private val callback: Callback<SpeakerResponseK> = object: Callback<SpeakerResponseK> {
        override fun onResponse(call: Call<SpeakerResponseK>?, response: Response<SpeakerResponseK>?) {
            hideLoading()

            log({"onResponse $response.body()"})
            renderSpeakers(response!!.body().data)
        }

        override fun onFailure(call: Call<SpeakerResponseK>?, t: Throwable?) {
            if(!call!!.isCanceled){
                hideLoading()
            }

            log({"onFailure $t"})
        }
    }

    override fun showLoading() {
       relativeLayoutProgress.visibility=View.VISIBLE
    }

    override fun hideLoading() {
        if(relativeLayoutProgress!=null) relativeLayoutProgress.visibility=View.GONE
    }


}