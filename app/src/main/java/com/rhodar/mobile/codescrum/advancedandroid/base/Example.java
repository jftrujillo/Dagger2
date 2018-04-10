package com.rhodar.mobile.codescrum.advancedandroid.base;

import android.app.Activity;

import com.rhodar.mobile.codescrum.advancedandroid.home.MainActivity;
import com.rhodar.mobile.codescrum.advancedandroid.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MainActivityComponent.class
})

public abstract class Example {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector()
}

