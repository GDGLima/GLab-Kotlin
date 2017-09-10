package com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.data.model.SponsorResponseK
import com.gdglima.glabkotlin.gdglimaapp.data.storage.ApliClientK
import com.gdglima.glabkotlin.gdglimaapp.model.EntityK
import com.gdglima.glabkotlin.gdglimaapp.ui.adapterskt.SponsorAdapterK
import kotlinx.android.synthetic.main.fragment_sponsors.*
import kotlinx.android.synthetic.main.layout_progress.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by emedinaa on 2/09/17.
 */
class SponsorsFragmentK : BaseFragmentK<SponsorResponseK>() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    private var sponsorAdapter: SponsorAdapterK?=null
    private var gridLayoutManager:GridLayoutManager?=null;
    private var linearLayoutManager:LinearLayoutManager?=null;

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): SponsorsFragmentK {
            var args: Bundle = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)

            var homeFragment: SponsorsFragmentK = newInstance()
            homeFragment.arguments = args
            return homeFragment
        }

        fun newInstance(): SponsorsFragmentK {
            return SponsorsFragmentK()
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
        return inflater!!.inflate(R.layout.fragment_sponsors, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ui();
        requestSponsors();
    }

    private fun ui(){
        linearLayoutManager = LinearLayoutManager(activity)
        //gridLayoutManager= GridLayoutManager(activity!!,2)

        recyclerViewSponsors.layoutManager= linearLayoutManager
        //recyclerViewSponsors.layoutManager= gridLayoutManager
    }

    private fun requestSponsors(){
        showLoading()
        //ApliClientK.getMyApiClient().sponsors()
        //val call: Call<SponsorResponseK> = ApliClientK.getMyApiClient().sponsors()
        currentCall= ApliClientK.getMyApiClient().sponsors()
        currentCall!!.enqueue(callback)
    }



    private fun renderSponsors(sponsors:List<EntityK.SponsorK>){
        if(activity!=null){
            sponsorAdapter= SponsorAdapterK(activity,sponsors,activity)
            recyclerViewSponsors.setAdapter(sponsorAdapter)

            /*val spanSizeLookip: GridLayoutManager.SpanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    // return adapter.isHeader(position) ? manager.getSpanCount() : 1;
                    if(sponsorAdapter!!.isHeader(position))return  gridLayoutManager!!.spanCount
                    return 1;
                }
            }
            gridLayoutManager!!.spanSizeLookup=spanSizeLookip*/

        }
    }
    //endpoints
    private val callback: Callback<SponsorResponseK> = object: Callback<SponsorResponseK> {
        override fun onResponse(call: Call<SponsorResponseK>?, response: Response<SponsorResponseK>?) {
            log({"onResponse $response.body()"})
            hideLoading()
            //renderSpeakers(response!!.body().data)
            renderSponsors(response!!.body().data)
        }

        override fun onFailure(call: Call<SponsorResponseK>?, t: Throwable?) {
            if(!call!!.isCanceled){
                hideLoading()
            }
            log({"onFailure $t"})
        }
    }

    override fun showLoading() {
        relativeLayoutProgress.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        relativeLayoutProgress.visibility= View.GONE
    }
}

