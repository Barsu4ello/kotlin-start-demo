package lesson6

import lesson6.calculator.Calculator
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    init {
        println("init")
    }

//    //PER_METHOD
//    companion object {
//        @BeforeAll
//        @JvmStatic // создает реальный статик метод, внутри которого вызывается метод компаньона
//        fun prepare() {
//            println("prepare")
//        }
//    }

    @BeforeAll
    fun prepare() {
        println("prepare")
    }


    @BeforeEach
    fun prepareTest() {
        println("prepareTest")
    }

    @AfterAll
    fun destroy() {
        println("destroy")
    }

    @Test
    @DisplayName("Тестирование метода add()")
    fun calcAdd() {
        println("calcAdd()")
        val calc = Calculator(15)
        calc.add(5)
        assertEquals(20, calc.get(), "15 + 5 should be equal 20")
    }

    @Test
    @DisplayName("Тестирование метода mul()")
    fun calcMul() {
        println("calcMul()")
        val calc = Calculator(25)
        calc.mul(2)
        assertEquals(50, calc.get(), "25 * 2 should be equal 50")
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        "0, 1, 1",
        "10, 5, 15",
        "1, 100, 101"
    )
    @DisplayName("Параметризованный тест для add()")
    fun paramAdd(f: Int, s: Int, r: Int) {
        println("paramAdd()")
        val calc = Calculator(f)
        calc.add(s)
        assertEquals(r, calc.get(), "$f + $s should be equal $r")
    }

    private fun data(): Stream<Arguments> = Stream.of(
        Arguments.of(0, 0, 0),
        Arguments.of(0, 3, 0),
        Arguments.of(12, 6, 72)

    )

    private fun data2(): Stream<Arguments> = Stream.of(
        Arguments.of(3, 6, 18)
    )

    @ParameterizedTest(name = "{0} * {1} = {2}")
//    @MethodSource("data", "data2") // или разделить на 2 аннотации как ниже
    @MethodSource("data")
    @MethodSource("data2")
    @DisplayName("Параметризованный тест для mul()")
    fun paramMul(f: Int, s: Int, r: Int) {
        println("paramMul()")
        val calc = Calculator(f)
        calc.mul(s)
        assertEquals(r, calc.get(), "$f * $s should be equal $r")
    }

    @Disabled
    @Test
    @DisplayName("Проверка div() при делении на 0")
    fun divisionByZeroThrowsException() {
        val calc = Calculator(10)
        val exception = assertThrows<IllegalArgumentException> {
            calc.div(0)
        }
        assertEquals("Division by zero", exception.message, "Should be 'Division by zero'")
    }

    @Test
    @DisplayName("Проверка нескольких функций в одном тесте")
    fun combineAddAndMul() {
        val calc = Calculator(15)
        assertAll(
            "Проверка 3 условий",
            {
                assertEquals(15, calc.get())
            },
            {
                calc.add(2)
                assertEquals(17, calc.get())
            },
            {
                calc.mul(3)
                assertEquals(51, calc.get())
            }
        )
    }

}