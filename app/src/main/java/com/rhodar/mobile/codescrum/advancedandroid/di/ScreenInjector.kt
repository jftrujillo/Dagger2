@file:Suppress("UNCHECKED_CAST")

package com.rhodar.mobile.codescrum.advancedandroid.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import com.rhodar.mobile.codescrum.advancedandroid.base.BaseActivity
import com.rhodar.mobile.codescrum.advancedandroid.base.BaseController
import dagger.android.AndroidInjector
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject
import kotlin.reflect.jvm.internal.impl.javax.inject.Provider


@ActivityScope
class ScreenInjector @Inject constructor(private val screenInjectors: Map<Class<out Controller>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Controller>>>) {
    companion object {
        fun get(activity: Activity) : ScreenInjector{
            if (activity !is BaseActivity){
                throw java.lang.IllegalArgumentException("Controller must be hosted by BaseActivity")
            }
            return (activity as BaseActivity).screenInjector
        }
    }



    private val cache = HashMap<String,AndroidInjector<out Controller>>()

    fun inject(controller : Controller){
        if (controller !is BaseController){
            throw IllegalArgumentException("Controller must extend BaseController")
        }
        val instanceId = controller.instanceId
        if (cache.containsKey(instanceId)){
            (cache[instanceId] as AndroidInjector<Controller>).inject(controller)
            return
        }
        val injectorFactory : AndroidInjector.Factory<Controller> = screenInjectors[controller::class.java]?.get() as AndroidInjector.Factory<Controller>
        val injector = injectorFactory.create(controller)
        if (injector != null) {
            cache[instanceId] = injector
        }
        injector.inject(controller)
    }

    fun clear(controller: Controller){
        if (controller !is BaseController){
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }
        cache.remove(controller.getInstanceId())
    }
}

