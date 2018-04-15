package com.rhodar.mobile.codescrum.advancedandroid.di

import com.bluelinelabs.conductor.Controller
import dagger.MapKey
import kotlin.reflect.KClass


@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ControllerKey(@JvmSuppressWildcards val value: KClass<out Controller>)