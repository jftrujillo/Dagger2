package com.rhodar.mobile.codescrum.advancedandroid.base

import android.content.Context
import com.bluelinelabs.conductor.Controller
import com.rhodar.mobile.codescrum.advancedandroid.di.Injector


abstract class BaseController() : Controller() {

    private var injected = false
    override fun onContextAvailable(context: Context) {
        super.onContextAvailable(context)
        //Controller instances are retained across changes in configuration, so with this we don't wate time injecting
        //dependencies over and over
        if(!injected){
            Injector.inject(this)
            injected = true
        }
    }
}