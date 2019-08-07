package com.amaglovany.ktx

import java.lang.ref.WeakReference

fun <T> T.weak() = WeakReference(this)
fun <T> T.unit() = Unit

fun Boolean.toInt() = if (this) 1 else 0
fun Int.toBoolean() = this != 0

val Any.className: String get() = javaClass.simpleName
val Any.uniqueName: String get() = this::class.java.simpleName + "@" + hashCode()
