package lesson4.tasks

data class RationalNumber(var numerator: Int, var denominator: Int)

fun Int.r(): RationalNumber = RationalNumber(this, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

fun main() {
    val rationalNumber1 = 12.r()
    println(rationalNumber1)
    val rationalNumber2 = Pair(12,12).r()
    println(rationalNumber2)
    val rationalNumber3 = (25 to 45).r()
    println(rationalNumber3)
}