package com.rhodar.mobile.codescrum.advancedandroid.base

import android.app.Application
import com.rhodar.mobile.codescrum.advancedandroid.di.ActivityInjector
import javax.inject.Inject

class App : Application() {
    lateinit var appComponent: AppComponent

    @Inject
    private lateinit var activityInjector : ActivityInjector

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
    }

    fun getActivityInjector() : ActivityInjector{
        return activityInjector
    }
}