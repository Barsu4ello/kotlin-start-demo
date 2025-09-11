package lesson6.functions

//функции расширения
fun Int.isOdd(): Boolean = this % 2 != 0
fun Int.isEven(): Boolean = this % 2 == 0

//свойства расширения (Кстати можно и var но логика редко для такого подходит)
val Int.odd: Boolean
    get() = this % 2 != 0

val Int.even: Boolean
    get() = this % 2 == 0

//лямбда расширения
val isOddLambda: Int.() -> Boolean = { this % 2 != 0 }
val isEvenLambda: Int.() -> Boolean = { this % 2 == 0 }

fun Collection<String>.formatString(prefix: String = "[", suffix: String = "]", delim: String = ","): String =
//    this.joinToString(delim) { "$prefix$it$suffix" }
    this.joinToString(delim, prefix, suffix)

fun Collection<String>.formatString2(
    prefix: String = "[",
    suffix: String = "]",
    delim: String = ",",
    processor: (String) -> String = { it }
): String =
    this.joinToString(delim, prefix, suffix) { processor(it) }


fun main() {
    println(12.isOdd())
    println(13.isOdd())
    println(12.isEven())
    println(13.isEven())

    println("----------------")

    println(12.odd)
    println(13.odd)
    println(12.even)
    println(13.even)

    println("----------------")

    println(12.isOddLambda())
    println(13.isOddLambda())
    println(12.isEvenLambda())
    println(13.isEvenLambda())

    println(listOf("1", "2", "3").formatString(prefix = "{", suffix = "}"))
    println(listOf("111", "22222", "3333333").formatString2(prefix = "{", suffix = "}"){"${it.length}"})


}

