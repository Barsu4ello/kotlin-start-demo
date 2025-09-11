package lesson7

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito

class BookServiceTest {

    @Test
    @DisplayName("Тест на вызов методов inStock и lend при вызове LendBookManager")
    fun verifyInStockAndLendInvoke() {

        val bookService = Mockito.mock(BookService::class.java)
        Mockito.doReturn(true).`when`(bookService).inStock(100)

        val lendBookManager = LendBookManager(bookService)
        lendBookManager.checkout(100, 10)

        Mockito.verify(bookService).inStock(100)
        Mockito.verify(bookService).lend(100, 10)
        Mockito.verifyNoMoreInteractions(bookService)
    }

    @Test
    @DisplayName("Тест на вызов методов inStock и lend при вызове LendBookManager с учетом порядка")
    fun verifyInStockAndLendInvokeWithOrder() {

        val bookService = Mockito.mock(BookService::class.java)
        Mockito.doReturn(true).`when`(bookService).inStock(100)

        val inOrder = Mockito.inOrder(bookService)

        val lendBookManager = LendBookManager(bookService)
        lendBookManager.checkout(100, 10)

        inOrder.verify(bookService).inStock(100)
        inOrder.verify(bookService).lend(100, 10)
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    @DisplayName("Тест на выбрасывание IllegalStateException")
    fun throwIllegalStateException() {

        val bookService = Mockito.mock(BookService::class.java)
        Mockito.doReturn(false).`when`(bookService).inStock(200)

        val lendBookManager = LendBookManager(bookService)

        val exception = assertThrows<IllegalStateException> { lendBookManager.checkout(200, 10) }
        assertTrue { exception.message == "Book is not available" }

    }
}