package com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.base

/**
 * @author hossam.
 */
interface BaseContract {
    interface View<C> {
        val viewContext: C
    }

    interface Presenter
}
