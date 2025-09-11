import lesson1.greeting
import lesson1.japaneseSalary
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows


class Lesson1 {

    @Test
    fun greetSvetaIvanova() {
        assertEquals("Hello, Sveta Ivanova", greeting("Sveta", "Ivanova"))
    }

    // Так можно указывать имя на русском
    @Test
    fun `Имя для Светы Ивановой`() {
        assertEquals("Hello, Sveta Ivanova", greeting("Sveta", "Ivanova"))
    }

    @Test
    fun `Зарплата за 2 года станет 70_000`() {
        assertEquals(70_000.toBigDecimal(), japaneseSalary(50_000.toBigDecimal(), 2))
    }

    @Test
    fun `Зарплата за 2 года увеличится на 20_000`() {
        assertEquals(20_000.toBigDecimal(), japaneseSalary(50_000.toBigDecimal(), 2) - 50_000.toBigDecimal())
    }

    @Test
    fun `Если зп меньше 0 будет Exception`() {
        val assertThrows = assertThrows<IllegalArgumentException> { japaneseSalary(-50_000.toBigDecimal(), 2) }
        val message = assertThrows.message
        assertEquals("Зп должна быть больше 0", message)
    }
}