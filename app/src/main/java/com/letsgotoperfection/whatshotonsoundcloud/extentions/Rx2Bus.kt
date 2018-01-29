package com.letsgotoperfection.whatshotonsoundcloud.extentions

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


/**
 * @author hossam.
 */
object Rx2Bus {
    private val bus = PublishSubject.create<Any>()

    fun send(event: Any) {
        bus.onNext(event)
    }

    fun toObservable(): Observable<Any> {
        return bus
    }

    fun hasObservers(): Boolean {
        return bus.hasObservers()
    }
}