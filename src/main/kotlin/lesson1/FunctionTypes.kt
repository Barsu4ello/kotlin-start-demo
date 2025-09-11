package lesson1

fun main() {
    println(greeting("Вася", "Петров"))
    //можно указывать параметры и менять порядок
    println(greeting(last = "Вася", first = "Петров"))
    println(greeting(1, "Циферов"))
    println(greeting(1))
    println(greeting("Вася"))
    println(greeting(" "))
}

//fun greeting(first: String, last: String): String {
//   return  "Hello, $first $last"
//}
// аналог функции выше
fun greeting(first: String, last: String) = "Hello, $first $last"

fun greeting(first: Int, last: String = "Дефолтов") = "Hello, $first $last"

fun greeting(first: String): String {
    require(first.isNotBlank()) {"Нужно непустое имя"} // Бросит ошибку, если не пройдет условие
    // Ниже функции тоже для проверки(почитай если будет интересно)
//    requireNotNull()
//    check()
//    assert()
    return "Hello, $first"
}

// Можно использовать русские буквы
fun `сумма 2 чисел`(): Int {
    val `первое число` = (age ?: 0) + 3
    val `второе число` = 8

    return `первое число` + `второе число`
}

