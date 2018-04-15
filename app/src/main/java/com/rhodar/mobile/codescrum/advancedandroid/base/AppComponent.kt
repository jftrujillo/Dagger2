package com.rhodar.mobile.codescrum.advancedandroid.base

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,ActivityBindingModule::class])
interface AppComponent {
    fun inject(app: App)
}