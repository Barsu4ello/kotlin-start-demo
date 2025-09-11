package lesson4.tasks

fun String?.isEmptyOrNull(): Boolean = this?.isEmpty() ?: true

fun main() {
    println("".isEmptyOrNull())
    val str: String? = null
    println(str.isEmptyOrNull())
    println("1".isEmptyOrNull())
    println("       ".isEmptyOrNull())
}
