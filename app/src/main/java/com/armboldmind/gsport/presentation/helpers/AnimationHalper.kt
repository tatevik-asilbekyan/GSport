package com.armboldmind.gsport.presentation.helpers

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation

fun getTranslateAndFadeOutAnimation(
    duration: Long,
    offset: Long,
    ShiftAmountPixel: Int
): AnimationSet {
    val totalAnimation = AnimationSet(true)
    totalAnimation.duration = duration
    totalAnimation.startOffset = offset
    totalAnimation.fillAfter = true
    val animAlpha: Animation = AlphaAnimation(1.0f, 0.0f)
    val animTranslateY: Animation = TranslateAnimation(0F, 0F, ShiftAmountPixel.toFloat(), 0F)
    totalAnimation.addAnimation(animAlpha)
    totalAnimation.addAnimation(animTranslateY)
    return totalAnimation
}

fun getTranslateAndFadeInAnimation(
    duration: Long,
    offset: Long,
    ShiftAmountPixel: Int
): AnimationSet {
    val totalAnimation = AnimationSet(true)
    totalAnimation.duration = duration
    totalAnimation.startOffset = offset
    totalAnimation.fillAfter = true
    val animAlpha: Animation = AlphaAnimation(1.0f, 0.0f)
    val animTranslateY: Animation = TranslateAnimation(0F, 0F, 0F, ShiftAmountPixel.toFloat())
    totalAnimation.addAnimation(animAlpha)
    totalAnimation.addAnimation(animTranslateY)
    return totalAnimation
}

fun fadeViewIn(duration: Int, view: View?) {
    val fadeIn: Animation = getFadeInAnimation(duration.toLong())
    view?.visibility = View.VISIBLE
    view?.startAnimation(fadeIn)
}

fun getFadeInAnimation(duration: Long): AlphaAnimation {
    return getFadeInAnimation(duration, 0)
}

fun getFadeInAnimation(duration: Long, delay: Long): AlphaAnimation {
    return getFadeInAnimation(duration, delay, 0.0f, 1.0f)
}

fun getFadeInAnimation(
    duration: Long,
    delay: Long,
    StartAlpha: Float,
    EndAlpha: Float
): AlphaAnimation {
    val animation = AlphaAnimation(StartAlpha, EndAlpha)
    animation.duration = duration
    animation.startOffset = delay
    animation.fillAfter = true
    return animation
}
