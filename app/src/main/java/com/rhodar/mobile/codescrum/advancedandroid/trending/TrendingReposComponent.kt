package com.rhodar.mobile.codescrum.advancedandroid.trending

import com.rhodar.mobile.codescrum.advancedandroid.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector


@ScreenScope
@Subcomponent
interface TrendingReposComponent : AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TrendingReposController>()

}