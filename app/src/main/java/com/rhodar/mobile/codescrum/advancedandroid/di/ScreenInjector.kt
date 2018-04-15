package com.rhodar.mobile.codescrum.advancedandroid.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import com.rhodar.mobile.codescrum.advancedandroid.base.BaseActivity
import com.rhodar.mobile.codescrum.advancedandroid.base.BaseController
import dagger.android.AndroidInjector
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject
import kotlin.reflect.jvm.internal.impl.javax.inject.Provider


@ActivityScope
class ScreenInjector @Inject constructor(val screenInjectors: Map<Class<Controller>, Provider<AndroidInjector.Factory<Controller>>>) {
    companion object {
        fun get(activity: Activity) : ScreenInjector{
            if (activity !is BaseActivity){
                throw java.lang.IllegalArgumentException("Controller must be hosted by BaseActivity")
            }
            return activity.screenInjector
        }
    }

    private val cache = HashMap<String,AndroidInjector<Controller>>()

    fun inject(controller : Controller){
        if (controller !is BaseController){
            throw IllegalArgumentException("Controller must extend BaseController")
        }
        val instanceId = controller.instanceId
        if (cache.containsKey(instanceId)){
            cache[instanceId]!!.inject(controller)
            return
        }
        val injectorFactory = screenInjectors[controller::class.java]?.get()
        val injector = injectorFactory?.create(controller)
        if (injector != null) {
            cache[instanceId] = injector
            injector.inject(controller)
        }
    }

    fun clear(controller: Controller){
        if (controller !is BaseController){
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }
        cache.remove(controller.getInstanceId())
    }
}

