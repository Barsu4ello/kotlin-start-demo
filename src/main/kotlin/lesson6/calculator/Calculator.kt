package lesson6.calculator

class Calculator(private var result: Int = 0) {

    fun get() = result
    fun add(other: Int): Unit {
        result += other
    }

    fun sub(other: Int): Unit {
        result -= other
    }

    fun mul(other: Int): Unit {
        result *= other
    }

    fun div(other: Int): Unit {
        require(other != 0) { "Division by zero" }
        result /= other
    }

}

fun main() {

    val calc = Calculator()
    println(calc.add(25))
    println(calc.get())
    println(calc.div(0))
}