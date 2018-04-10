package com.rhodar.mobile.codescrum.advancedandroid.home

import com.rhodar.mobile.codescrum.advancedandroid.di.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector


@ActivityScope
@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {

    }
}