package lesson8

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test

class TestHamcrest {

    @Test
    fun testHamcrest() {
        assertThat("hello", equalTo("hello"))
        assertThat("hello", endsWith("o"))
        assertThat("hello", anything())
        assertThat("hello", not("world"))
    }
}