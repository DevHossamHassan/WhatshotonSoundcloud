package com.letsgotoperfection.kotlin_clean_architecture_mvp_sample

import io.reactivex.Observable
import io.reactivex.Single
import org.mockito.configuration.DefaultMockitoConfiguration
import org.mockito.internal.stubbing.defaultanswers.ReturnsEmptyValues
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

/**
 * @author hossam.
 */
class MockitoConfiguration : DefaultMockitoConfiguration() {
    override fun getDefaultAnswer(): Answer<Any> {
        return object : ReturnsEmptyValues() {
            override fun answer(inv: InvocationOnMock): Any {
                val type = inv.method.returnType
                return if (type.isAssignableFrom(Observable::class.java)) {
                    Observable.error<Any>(createException(inv))
                } else if (type.isAssignableFrom(Single::class.java)) {
                    Single.error<Any>(createException(inv))
                } else {
                    super.answer(inv)
                }
            }
        }
    }

    private fun createException(
            invocation: InvocationOnMock): RuntimeException {
        val s = invocation.toString()
        return RuntimeException(
                "No mock defined for invocation " + s)
    }
}