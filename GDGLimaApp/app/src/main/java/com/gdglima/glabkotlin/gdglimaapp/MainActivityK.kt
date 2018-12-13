package com.gdglima.glabkotlin.gdglimaapp;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.text.TextUtils.replace
import android.view.MenuItem
import com.gdglima.glabkotlin.gdglimaapp.ui.BaseActivityK
import com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt.HomeFragmentK
import com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt.ScheduleFragmentK
import com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt.SpeakersFragmentK
import com.gdglima.glabkotlin.gdglimaapp.ui.fragmentskt.SponsorsFragmentK
import kotlinx.android.synthetic.main.activity_main.*


class MainActivityK : BaseActivityK() {

    private var itemId=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app()
    }

    /**
     * Kotlin when
     * https://kotlinlang.org/docs/reference/basic-syntax.html
     */
    private fun app() {
        disabledDefaultAnimation()
        val menuItem:MenuItem= bottomNavigation.menu.getItem(0)
        itemId= menuItem.itemId
        changeFragment(HomeFragmentK.newInstance())

        bottomNavigation.setOnNavigationItemSelectedListener {item: MenuItem ->
            var fragment:Fragment?=null
            var tab=0
            itemId= item.itemId

            when(item.itemId){
                R.id.action_home -> {
                    tab = 0
                    fragment= HomeFragmentK.newInstance()
                }
                R.id.action_speakers ->  {
                    tab =1
                    fragment= SpeakersFragmentK.newInstance()
                }
                R.id.action_schedule-> {
                    tab=2
                    fragment= ScheduleFragmentK.newInstance()
                }
                R.id.action_sponsors-> {
                    tab=3
                    fragment= SponsorsFragmentK.newInstance()
                }
            }
            changeFragment(fragment)
            true
        }

        //slideDown(bottomNavigation)
    }

    private fun  changeFragment(fragment: Fragment?){
        fragment?.let {
            supportFragmentManager.beginTransaction().apply {
               replace(R.id.frameLayout,it,null)
               commit()
            }
        }
    }

}
