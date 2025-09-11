import lesson2.allMatchesOf
import lesson2.date
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Lesson2 {

    @Test
    @DisplayName("Корректная дата вернет true")
    fun validDateReturnTrue() {
        assertTrue(date("12 JAN 2020"))
    }

    @Test
    @DisplayName("Некорректная дата вернет false")
    fun invalidDateReturnFalse() {
        assertFalse( date("123 JAN 2020"))
        assertFalse( date("12 JANn 2020"))
    }

    @Test
    @DisplayName("Тест функции fizzBuzz на все 3 случай")
    fun fizzBuzz() {
       assertEquals("Fizz: 3", lesson2.fizzBuzz(3))
       assertEquals("Buzz: 5", lesson2.fizzBuzz(5))
       assertEquals("FizzBuzz: 15", lesson2.fizzBuzz(15))
       assertEquals("4", lesson2.fizzBuzz(4))
    }

    @Test
    @DisplayName("Тест функции String.allMatchesOf")
    fun allMatchesOf() {
        val testString = "123_555_123_123_55"
        val listOf = listOf("123", "123", "123")
        assertIterableEquals(listOf, testString.allMatchesOf("123".toRegex()))
    }
}