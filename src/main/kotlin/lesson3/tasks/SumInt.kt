package lesson3.tasks

fun List<Int>.sum(): Int = this.reduce { acc, i -> acc + i }

fun main() {
    val list = listOf(2, 3, 4,)
    val sum = list.sum()
    println(sum)
}