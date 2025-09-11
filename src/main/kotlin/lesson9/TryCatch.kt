package lesson9

import java.io.BufferedReader
import java.io.FileReader
import javax.swing.SwingUtilities


fun main() {
    var list: List<Int>? = listOf(1,2,3,4,5)
    val result = try { // возвращает последнюю строку или в try или в catch
        for (i in -10..1) {
            println(45 / i)
        }
        "123"
    } catch (e: ArithmeticException) {
        println("caught exc: ${e.message}")
    } finally {
        list = null
        println("finally")
    }

    println(result)

    // замена try-with-resources (только если нужен catch, то оборачивай в try-catch блок сверху)
    BufferedReader(FileReader("src/main/resources/questions.txt")).use { br ->
        val line = br.readLine()
        println(line)
    }
}