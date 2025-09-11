package lesson3.tasks

fun fib(number: Int): Int {
    if(number < 3) return 1
    var first = 1
    var second = 1
    var i = 3
    while(i <= number) {
        val temp = first + second
        first = second
        second = temp
        i++
    }
    return second
}

fun main() {
    println(fib(1))
    println(fib(2))
    println(fib(3))
    println(fib(10))
}