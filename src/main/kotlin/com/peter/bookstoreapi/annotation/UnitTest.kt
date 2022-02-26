package com.peter.bookstoreapi.annotation

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith


@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@ExtendWith(MockKExtension::class)
@Tag("unit")
annotation class UnitTest