package lesson4

//Обычная функция расширения
//fun Int.sm(other: Int): Int = this + other
//infix форма для функции расширения
infix fun Int.sm(other: Int): Int = this + other


fun main() {
    println(34.sm(13))
    println(34 sm 13)
}