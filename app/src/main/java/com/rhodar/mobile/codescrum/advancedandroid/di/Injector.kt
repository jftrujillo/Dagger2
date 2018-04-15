package com.rhodar.mobile.codescrum.advancedandroid.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller


class Injector{
    companion object {

        fun inject(activity: Activity) = ActivityInjector.get(activity).inject(activity)

        fun inject(controller : Controller) {}

        fun clearComponent(activity: Activity){}
    }
}