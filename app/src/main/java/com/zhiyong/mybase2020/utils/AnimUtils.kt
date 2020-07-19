package com.zhiyong.mybase2020.utils

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.DecimalFormat
import java.util.concurrent.TimeUnit

class AnimUtils {
    companion object {
        private val SLIDE_OUT_LEFT = 250
        private val SLIDE_IN_LEFT_DURATION = 300

        @JvmStatic
        fun animateIntegerText(pValueAnimator: ValueAnimator,
                               pPrefix: String, pPostfix: String, pTextView: TextView
        ) {
            val `val` = pValueAnimator.animatedValue as Int
            val formatter = DecimalFormat("#,###,###")
            val yourFormattedString = formatter.format(`val`.toLong())
            pTextView.text = pPrefix + yourFormattedString + pPostfix
        }

        @JvmStatic
        fun animateFloatText(pValueAnimator: ValueAnimator,
                             pPrefix: String, pPostfix: String, pTextView: TextView
        ) {
            val `val` = pValueAnimator.animatedValue as Float

            var formatter = DecimalFormat("###.#")
            if (`val` < 1)
                formatter = DecimalFormat("###.##")

            val yourFormattedString = formatter.format(`val`.toDouble())
            pTextView.text = pPrefix + yourFormattedString + pPostfix
        }

        @JvmStatic
        fun animateHeight(pValueAnimator: ValueAnimator,
                          pView: ViewGroup
        ) {
            val `val` = pValueAnimator.animatedValue as Int
            pView.layoutParams.height = `val`
            pView.requestLayout()

        }

        @JvmStatic
        fun animateWidth(pValueAnimator: ValueAnimator,
                         pView: ViewGroup
        ) {
            val `val` = pValueAnimator.animatedValue as Int
            pView.layoutParams.width = `val`
            pView.requestLayout()
        }

//        fun animateInFromLeft(pView: View, startDelay: Long,
//                              pListener: Animator.AnimatorListener?) {
//            val animator = ObjectAnimator.ofFloat(pView, "xFraction", -1f)
//            if (pListener != null)
//                animator.addListener(pListener)
//            animator.setStartDelay(startDelay)
//
//            animator.start()
//        }

        fun animateFadeout(pView: View){
            val scaleUp = ObjectAnimator.ofPropertyValuesHolder(
                pView,
                PropertyValuesHolder.ofFloat("alpha", 0f)
            )
            scaleUp.duration = 300
            scaleUp.start()
        }
        fun animateScaleUp(pView: View) {
            pView.visibility= View.VISIBLE
            pView.scaleX=0.5f
            pView.scaleY=0.5f
            pView.alpha=0f
            val scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                pView,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f),PropertyValuesHolder.ofFloat("alpha", 1f)
            )
            scaleDown.duration = 300

            //scaleDown.repeatMode = ValueAnimator.REVERSE
            //scaleDown.repeatCount = ValueAnimator.
            scaleDown.start()
        }

        fun startStopLottieAnimation(parent: ViewGroup, isPause: Boolean) {
            for (i in parent.childCount - 1 downTo 0) {
                val child = parent.getChildAt(i)
                if (child is ViewGroup) {
                    startStopLottieAnimation(child, isPause)
                } else {
                    if (child != null) {

                        if (child is LottieAnimationView) {

                            if (isPause || child.visibility != View.VISIBLE) {
                                Log.d(AnimUtils::class.java.name, "Lotti Animation Cancelled")
                                playCancelLottieAnimation(child, false)
                            } else {
                                Log.d(AnimUtils::class.java.name, "Lotti Animation Started")
                                playCancelLottieAnimation(child, true)

                            }


                        }
                    }
                }
            }
        }

        fun loadAnimationForView(view: View, second:Long)
        {
            Observable.timer(second, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map({ o ->  animateScaleUp(view) })
                .subscribe()
        }

        fun playCancelLottieAnimation(lottieAnimationView: LottieAnimationView, shouldStart: Boolean) {

            if (shouldStart) {
                lottieAnimationView.loop(true)
                lottieAnimationView.playAnimation()
                return
            }

            lottieAnimationView.loop(false)
            lottieAnimationView.cancelAnimation()
        }
    }
}
