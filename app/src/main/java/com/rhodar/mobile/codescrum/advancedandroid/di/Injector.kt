package com.rhodar.mobile.codescrum.advancedandroid.di

import android.app.Activity
import com.rhodar.mobile.codescrum.advancedandroid.base.BaseActivity


class Injector{
    companion object {

        fun inject(activity: Activity){
        ActivityInjector.get(activity).inject(activity)
        }

        fun clearComponent(activity: Activity) {
            ActivityInjector.get(activity).clear(activity)
        }
    }
}