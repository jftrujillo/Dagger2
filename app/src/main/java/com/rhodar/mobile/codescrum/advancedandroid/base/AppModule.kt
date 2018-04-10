package com.rhodar.mobile.codescrum.advancedandroid.base

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule(private val app: Application) {


    @Provides
    fun provideApplicationContext(): Context {
        return app
    }

}