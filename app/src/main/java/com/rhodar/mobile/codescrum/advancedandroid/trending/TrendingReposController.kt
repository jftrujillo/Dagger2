package com.rhodar.mobile.codescrum.advancedandroid.trending

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhodar.mobile.codescrum.advancedandroid.base.BaseController
import com.rhodar.mobile.codescrum.advancedandroid.home.MainActivity
import io.reactivex.annotations.NonNull
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject

class TrendingReposController : BaseController() {

    @Inject lateinit var activity : MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return  container
    }


}