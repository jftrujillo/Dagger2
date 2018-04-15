package com.rhodar.mobile.codescrum.advancedandroid.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.rhodar.mobile.codescrum.advancedandroid.R
import com.rhodar.mobile.codescrum.advancedandroid.di.Injector
import com.rhodar.mobile.codescrum.advancedandroid.di.ScreenInjector
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {
    private val INSTANCE_ID_KEY = "instance_id"
    private lateinit var instanceId: String
    private lateinit var router: Router

    @Inject
    lateinit var screenInjector: ScreenInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = if (savedInstanceState != null) savedInstanceState.getString(INSTANCE_ID_KEY)
        else UUID.randomUUID().toString()
        Injector.inject(this)
        setContentView(layoutRes())
        val screenContainer = findViewById<ViewGroup>(R.id.screen_container) ?: throw NullPointerException("Activity must have a view with id screen_container")
        router = Conductor.attachRouter(this,screenContainer,savedInstanceState)
        monitorBackStack()
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(INSTANCE_ID_KEY, instanceId)

    }

    fun getInstanceId(): String = instanceId

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            Injector.clearComponent(this)
        }
    }

    private fun monitorBackStack() {
        router.addChangeListener(object : ControllerChangeHandler.ControllerChangeListener{
            override fun onChangeStarted(to: Controller?,
                                         from: Controller?,
                                         isPush: Boolean,
                                         container: ViewGroup,
                                         handler: ControllerChangeHandler) {

            }

            override fun onChangeCompleted(to: Controller?,
                                           from: Controller?,
                                           isPush: Boolean,
                                           container: ViewGroup,
                                           handler: ControllerChangeHandler) {

                if (!isPush && from != null){
                    Injector.clearComponent(from)
                }

            }

        })
    }

}
