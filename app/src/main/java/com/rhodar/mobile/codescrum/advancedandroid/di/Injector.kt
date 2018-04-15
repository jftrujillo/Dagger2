package com.rhodar.mobile.codescrum.advancedandroid.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller


class Injector{
    companion object {

        fun inject(activity: Activity) = ActivityInjector.get(activity).inject(activity)

        fun inject(controller : Controller)  = ScreenInjector.get(controller.activity!!).inject(controller)

        fun clearComponent(activity: Activity){}

        fun clearComponent(controller: Controller) = ScreenInjector.get(controller.activity!!).clear(controller)
    }
}