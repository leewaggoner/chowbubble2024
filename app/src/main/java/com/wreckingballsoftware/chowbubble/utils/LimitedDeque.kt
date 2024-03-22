package com.wreckingballsoftware.chowbubble.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <E> limitedDeque(limit: Int): ReadWriteProperty<Any?, ArrayDeque<E>> =
    object : ReadWriteProperty<Any?, ArrayDeque<E>> {
        private val deque = ArrayDeque<E>()

        override fun getValue(thisRef: Any?, property: KProperty<*>): ArrayDeque<E> {
            return deque
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: ArrayDeque<E>) {
            deque.add(value.last())
            if (deque.size > limit) {
                deque.removeFirst()
            }
        }
    }