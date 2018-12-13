package com.gdglima.glabkotlin.gdglimaapp;

import android.animation.Animator
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import com.gdglima.glabkotlin.gdglimaapp.ui.BaseActivityK
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivityK : BaseActivityK() {

    private val TIME:Long=2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        app()
    }

    private fun goToMain(){
        nextActivity(Intent(this, MainActivityK::class.java),true)
    }

    private fun app() {
        supportActionBar?.hide()
        log({"Start SplashActivityK"})
        /*Timer().schedule(timerTask {
            goToMain() },TIME)*/

        startAnimation()
    }

    private fun startAnimation(){
        //val fade:Fade = Fade(Fade.IN)
        //TransitionManager.beginDelayedTransition(imageViewLogo,fade);
        sceneInput()
    }

    private fun sceneInput(){
        imageViewLogo.scaleX=0.0f
        imageViewLogo.scaleY= 0.0f

        imageViewLogo.animate()
                .scaleX(1.0f)
                .scaleY(1.0f)
                .setInterpolator(BounceInterpolator())
                .setDuration(1000)
                .setListener(object:Animator.AnimatorListener{
                    override fun onAnimationRepeat(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        sceneOutput()
                    }

                    override fun onAnimationCancel(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onAnimationStart(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
    }

    private fun sceneOutput(){
        imageViewLogo.animate()
                .scaleX(0.0f)
                .scaleY(0.0f)
                .setInterpolator(AccelerateInterpolator())
                .setDuration(500)
                .setStartDelay(1000)
                .setListener(object :Animator.AnimatorListener{
                    override fun onAnimationRepeat(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onAnimationCancel(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onAnimationStart(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        reveal()
                    }

                })
    }

    private fun reveal(){
        val cx=(imageViewLogo.left + imageViewLogo.right)/2
        val cy=(imageViewLogo.top + imageViewLogo.bottom)/2
        val finalyRadius:Int= Math.max(constraintLayoutContainer.width/2,constraintLayoutContainer.height/2)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            constraintLayoutContainer.backgroundTintList= ColorStateList.valueOf(
                    ResourcesCompat.getColor(resources,R.color.blueGDGLima,null))

            val anim: Animator =
                    ViewAnimationUtils.createCircularReveal(constraintLayoutContainer,
                            cx, cy, 0.0f, finalyRadius.toFloat())
            anim.duration=200
            anim.addListener(object:Animator.AnimatorListener{
                override fun onAnimationRepeat(p0: Animator?) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAnimationEnd(p0: Animator?) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    goToMain()
                }

                override fun onAnimationCancel(p0: Animator?) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAnimationStart(p0: Animator?) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
            anim.start()
        }
    }

}
