package com.rhodar.mobile.codescrum.advancedandroid.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rhodar.mobile.codescrum.advancedandroid.di.Injector
import java.util.*

abstract class BaseActivity : AppCompatActivity() {
    private val INSTANCE_ID_KEY = "instance_id"
    private lateinit var instaceId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        instaceId =
                if (savedInstanceState != null) savedInstanceState.getString(INSTANCE_ID_KEY)
                else UUID.randomUUID().toString()


        Injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(INSTANCE_ID_KEY , instaceId)

    }

    fun getInstanceId() : String = instaceId

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing){
            Injector.clearComponent(this)
        }
    }
}