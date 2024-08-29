package com.example

import org.junit.Assert.assertEquals
import org.junit.Test

class AppTest {

    @Test
    fun testGreet() {
        val app = App()
        val expected = "Hello, Kotlin!"
        val actual = app.greet()
        assertEquals(expected, actual)
    }
}
