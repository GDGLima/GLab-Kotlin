package com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdglima.glabkotlin.gdglimaapp.R

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
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}