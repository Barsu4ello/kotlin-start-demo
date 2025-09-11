package lesson8.generics

inline fun <reified T> isParamType(any: Any): Boolean = any is T

fun main() {
    println(isParamType<String>("1233333"))
    println(isParamType<Int>("1233333"))
    println(isParamType<Number>("1233333"))
}