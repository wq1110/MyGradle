package com.example.mygradle

import android.view.View
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 *Created by Joyce.wang on 2024/7/8 17:47
 *@Description TODO
 */

class Resource

class Owner {
    var resource : Resource by ResourceDelegate()
}

class ResourceDelegate(var resource: Resource = Resource()) {
    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Resource {
        return this.resource
    }

    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, resource: Resource) {
        this.resource = resource
    }
}

class Foo {
    fun isValid(): Boolean {
        return true
    }

    fun doSomething() {
        println("do something")
    }
}

fun example(computeFoo: () -> Foo) {
    var someCondition = true
    val memoizedFoo by lazy(computeFoo)

    if (someCondition && memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
}

fun main() {
    example{
        Foo()
    }
    example{
        Foo()
    }
    for (i in 4 downTo 2) print(i)
}


fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }

    // 这里的obj仍然是Any类型的引用
    return null
}