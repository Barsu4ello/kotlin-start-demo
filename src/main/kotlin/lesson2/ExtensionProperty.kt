package lesson2


// свойство расширения
var StringBuilder.getLastChar: Char
    get() = this.last()
    set(value) {
        this.append(value)
    }

// функция расширения
fun StringBuilder.getLastChar(): Char = this.last()

fun main() {
    val sb = StringBuilder("hello world")
    sb.append("test")
    println(sb.getLastChar())
    println(sb)
    println(sb.getLastChar)
    sb.getLastChar = '!'
    println(sb)
}