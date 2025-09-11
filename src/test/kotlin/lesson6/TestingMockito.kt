package lesson6

import lesson6.mockito.MyClass
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.Captor
import org.mockito.Mockito
import java.util.*

class TestingMockito {

    @Test
    fun test1() {
        val test: MyClass = Mockito.mock(MyClass::class.java)
        Mockito.`when`(test.getUniqueId()).thenReturn(11)
        assertEquals(11, test.getUniqueId())
    }

    @Test
    fun testTwoReturnValues() {
        // Оба кейса одинаковый смысл имеют, просто разное приведение
//        val iter = Mockito.mock(Iterator::class.java)
//        Mockito.`when`(iter.next()).thenReturn("one").thenReturn("two")
//        assertEquals("one", iter.next())
//        assertEquals("two", iter.next())

        val iter = Mockito.mock(Iterator::class.java) as Iterator<String>
        Mockito.`when`(iter.next()).thenReturn("one").thenReturn("two")
        val result = iter.next() + " " + iter.next()
        assertEquals("one two", result)

    }

    @Test
    fun testComparableString() {
        val comparable = Mockito.mock(Comparable::class.java) as Comparable<String>
        Mockito.`when`(comparable.compareTo("Hello")).thenReturn(2)
        Mockito.`when`(comparable.compareTo("World")).thenReturn(4)

        assertAll(
            "Проверка компаратора",
            { assertEquals(2, comparable.compareTo("Hello")) },
            { assertEquals(4, comparable.compareTo("World")) }
        )
    }

    @Test
    fun testThrows() {
        val properties = Mockito.mock(Properties::class.java)
        Mockito.`when`(properties["Linux"]).thenReturn("OK")
        Mockito.`when`(properties["Anddddroid"]).thenThrow(IllegalArgumentException("Typo"))

        assertAll(
            "Проверка исключений",
            { assertEquals("OK", properties["Linux"]) },
            {
                val exc = assertThrows<IllegalArgumentException> { properties["Anddddroid"] }
                assertEquals("Typo", exc.message)
            },
        )
    }

    @Test
    fun testSpyWrong() {
        val list: List<String> = LinkedList()
        val spy = Mockito.spy(list)
//        Mockito.`when`(spy[0]).thenReturn("Hello") // тут будет ошибка, ибо вызовется spy[0] в процессе конфигурации spy объекта
        Mockito.doReturn("Hello").`when`(spy)[0]
        assertEquals("Hello", spy[0])
    }

    @Test
    fun testVerify() {
        val test = Mockito.mock(MyClass::class.java)
        Mockito.`when`(test.getUniqueId()).thenReturn(43)

        val inOrder = Mockito.inOrder(test) // объект, который может сохранять порядок вызова операций мока

        test.testing(12)
        test.getUniqueId()
        test.getUniqueId()

        Mockito.verify(test).testing(ArgumentMatchers.eq(12)) //Можно без ArgumentMatchers а просто передать аргумент
        Mockito.verify(test, Mockito.times(2)).getUniqueId()
        Mockito.verify(test, Mockito.atLeastOnce()).getUniqueId()
        Mockito.verify(test, Mockito.atLeast(2)).getUniqueId()
        Mockito.verify(test, Mockito.atMost(2)).getUniqueId()
        Mockito.verify(test, Mockito.atMost(10)).getUniqueId()
        Mockito.verify(test, Mockito.never()).someMethod("never called")
        Mockito.verifyNoMoreInteractions(test)

        //проверка порядка
        inOrder.verify(test).testing(ArgumentMatchers.eq(12))
        inOrder.verify(test, Mockito.times(2)).getUniqueId()

    }

    // Captor
    @Captor
    lateinit var stringCaptor: ArgumentCaptor<String>

    // Это класс от лектора. Типо если будет IllegalStateException в методе ниже помечено MockitoHelper
    // Но мне кажется он нес ересь ибо по сути мы просто делегируем такой же вызов captor.capture() классу MockitoHelper
    class MockitoHelper {
        fun <T> capture(captor: ArgumentCaptor<T>): T = captor.capture()
    }

    @Test
    fun shouldContainString() {
        stringCaptor = ArgumentCaptor.forClass(String::class.java)

        var list = LinkedList<Any>()
        val spy = Mockito.spy(list)
        spy.add("Hello")

        Mockito.verify(spy).add(stringCaptor.capture())
        assertEquals("Hello", stringCaptor.value)

//        println(stringCaptor.value)
//        println(stringCaptor.allValues)


        // MockitoHelper
        val helper = MockitoHelper()
        Mockito.verify(spy).add(helper.capture(stringCaptor))
        assertEquals("Hello", stringCaptor.value)
    }


}