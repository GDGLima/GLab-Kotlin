package com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt

import android.animation.Animator
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import com.gdglima.glabkotlin.gdglimaapp.R
import com.gdglima.glabkotlin.gdglimaapp.ui.EventsActivityK
import com.gdglima.glabkotlin.gdglimaapp.ui.WorkShopsActivityK
import kotlinx.android.synthetic.main.fragment_schedule.*

/**
 * Created by emedinaa on 2/09/17.
 */
class ScheduleFragmentK : Fragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    private var currentView:View?=null
    private var option:Int=0

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): ScheduleFragmentK {
            var args: Bundle = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)

            var homeFragment: ScheduleFragmentK = newInstance()
            homeFragment.arguments = args
            return homeFragment
        }

        fun newInstance(): ScheduleFragmentK {
            return ScheduleFragmentK()
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
        return inflater!!.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ui();
    }

    private fun goToActivities(){
        startActivity(Intent(activity,EventsActivityK::class.java))
    }

    private fun goToWorkshops(){
        startActivity(Intent(activity,WorkShopsActivityK::class.java))
    }

    private fun startReveal(color:Int,view:View,mOption:Int){
        currentView= view
        option=mOption
        val x= view.right
        val y = view.bottom

        val startRadius:Int= 0
        val endRadius:Int= Math.hypot(view.width.toDouble(),
                cardViewActivities.height.toDouble()).toInt()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.backgroundTintList= ColorStateList.valueOf(
                    ResourcesCompat.getColor(resources,color,null))

            val anim: Animator =
                    ViewAnimationUtils.createCircularReveal(view,
                            x, y, startRadius.toFloat(), endRadius.toFloat())

            anim.addListener(animationListener)

            anim.start()
        }

    }

    private fun gotoOption(){
        when(option){
            0 -> goToActivities()
            1 -> goToWorkshops()
        }
    }
    var animationListener= object : Animator.AnimatorListener{
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            Handler().postDelayed(
                    {
                        gotoOption()
                    },
            200)
        }
    }


    private fun ui(){
        cardViewActivities.setOnClickListener{
            if(cardViewActivities.tag==null){
                startReveal(R.color.yellowInfosoft,cardViewActivities,0)
                cardViewActivities.tag=1
            }

            //goToActivities()
        }
        cardViewWorkshops.setOnClickListener{
            //cardViewWorkshops.tag= if (cardViewWorkshops.tag==null) 1 else null
            //goToWorkshops()
            if(cardViewWorkshops.tag==null){
                startReveal(R.color.greenGDGLima,cardViewWorkshops,1)
                cardViewWorkshops.tag=1
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cardViewActivities.backgroundTintList= ColorStateList.valueOf(0)
            cardViewWorkshops.backgroundTintList= ColorStateList.valueOf(0)
            cardViewActivities.tag= null
            cardViewWorkshops.tag=null
        }
    }
}