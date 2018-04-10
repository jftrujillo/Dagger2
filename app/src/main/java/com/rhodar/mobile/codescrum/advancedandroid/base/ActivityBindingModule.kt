package com.rhodar.mobile.codescrum.advancedandroid.base

import android.app.Activity
import com.rhodar.mobile.codescrum.advancedandroid.home.MainActivity
import com.rhodar.mobile.codescrum.advancedandroid.home.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule{

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun provideMainActivityInjector(builder : MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}