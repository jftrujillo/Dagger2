package com.rhodar.mobile.codescrum.advancedandroid.base;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;


@MapKey
@Target(ElementType.METHOD)
public  @interface ExampleJava {
    Class<? extends Controller> value();
}
