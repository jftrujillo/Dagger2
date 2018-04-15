package com.rhodar.mobile.codescrum.advancedandroid.home

import com.bluelinelabs.conductor.Controller
import com.rhodar.mobile.codescrum.advancedandroid.di.ControllerKey
import com.rhodar.mobile.codescrum.advancedandroid.trending.TrendingReposComponent
import com.rhodar.mobile.codescrum.advancedandroid.trending.TrendingReposController
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


@Module(subcomponents = [TrendingReposComponent::class])
abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController::class)
    abstract fun bindTrendingsReposInjector(builder: TrendingReposComponent.Builder) : AndroidInjector.Factory<out Controller>

}