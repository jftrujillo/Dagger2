package com.rhodar.mobile.codescrum.advancedandroid.di

import android.app.Activity
import android.content.Context
import com.rhodar.mobile.codescrum.advancedandroid.base.App
import com.rhodar.mobile.codescrum.advancedandroid.base.BaseActivity
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

class ActivityInjector
@Inject
constructor(private val activityInjector : Map<Class<Activity>,Provider<AndroidInjector.Factory<Activity>>>){
    private val cache = HashMap<String,AndroidInjector<Activity>>()

    companion object {
        fun get(context : Context) : ActivityInjector{
                return (context.applicationContext as App).getActivityInjector()
        }
    }

    fun inject(activity : Activity){
        if (activity !is BaseActivity){
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }
        val instanceId = activity.getInstanceId()
        if (cache.containsKey(instanceId)){
            cache[instanceId]!!.inject(activity)
            return
        }
        val injectorFactory  = activityInjector[activity::class.java]?.get()
        val injector = injectorFactory?.create(activity)
        if (injector != null) {
            cache[instanceId] = injector
            injector.inject(activity)
        }
    }

    fun clear(activity: Activity){
        if (activity !is BaseActivity){
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }
        cache.remove(activity.getInstanceId())
    }



}
