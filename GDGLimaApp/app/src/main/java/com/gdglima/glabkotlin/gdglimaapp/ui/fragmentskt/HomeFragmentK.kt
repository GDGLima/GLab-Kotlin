package com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.R.id.*
import com.gdglima.glabkotlin.gdglimaapp.helpers.fadeIn
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by emedinaa on 2/09/17.
 */
class HomeFragmentK: Fragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): HomeFragmentK {
            var args: Bundle = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)

            var homeFragment: HomeFragmentK = newInstance()
            homeFragment.arguments = args
            return homeFragment
        }

        fun newInstance(): HomeFragmentK {
            return HomeFragmentK()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mParam1 = it.getString(ARG_PARAM1)
            mParam2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startAnimations()
    }

    private fun startAnimations(){
        //imageViewGDGLima.alpha=0.0f
        //imageViewMeetup.alpha=0.0f
        //imageViewFacebook.alpha=0.0f
        //imageViewTwitter.alpha=0.0f

        fadeIn(imageViewGDGLima)
        fadeIn(imageViewMeetup,1000,500)
        fadeIn(imageViewFacebook,1000,700)
        fadeIn(imageViewTwitter,1000,900)
        fadeIn(imageViewYoutube,1000,1000)
    }
}