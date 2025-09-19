package lesson11


operator fun Int.times(str: String) {
    //  println(str.repeat(this)) // Это бы просто повторило строку 5 раз и вернуло бы строку
    repeat(this) { println(str) }
}

infix fun Int.abc(str: String) {}

fun main() {
    5*"hello"
    5 abc "hello"
}