package lesson8

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class TestAssertJ {

    @Test
    fun testAssertJ() {
        assertThat("hello").isEqualTo("hello")
        assertThat("hello").endsWith("o")
        assertThat("hello").isNotEqualTo("world")
    }
}