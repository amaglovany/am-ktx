package com.amaglovany.ktx

import java.lang.ref.WeakReference
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> Delegates.weak(): ReadWriteProperty<Any, T?> = WeakVar(null)
fun <T> Delegates.weak(value: T): ReadWriteProperty<Any, T?> = WeakVar(value)

internal class WeakVar<T>(value: T?) : ReadWriteProperty<Any, T?> {
    private var reference: WeakReference<T>? = value?.weak()

    override fun getValue(thisRef: Any, property: KProperty<*>): T? = reference?.get()
    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        reference = value?.weak()
    }
}