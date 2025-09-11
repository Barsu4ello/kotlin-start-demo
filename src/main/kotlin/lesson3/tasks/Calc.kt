package lesson3.tasks

fun Any.print(): String = when (this) {
    is String -> "String: $this"
    is Int -> "Int: $this"
    else -> "Don't know: $this"
}

// создает абстрактный класс
sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
class Multiply(val left: Expr, val right: Expr) : Expr()

fun eval(expr: Expr): Int = when (expr) {
    is Num -> expr.value
    is Sum -> eval(expr.left) + eval(expr.right)
    is Multiply -> eval(expr.left) * eval(expr.right)
//    else -> throw IllegalArgumentException("Unknown expression")
}

open class Parent {
    constructor(x: Int) { /*...*/ }
}

class Child : Parent, Sayable {              // без ()
    constructor() : super(42) { }   // super вызываем здесь

    override fun say() {
        TODO("Not yet implemented")
    }
}

fun main() {
    val long: Long = 212
    val int: Int = long.toInt()
    val long2: Long = int.toLong()

    val int2: Int = "123".toInt()
    int2.javaClass
    println(int2.print())
    println(long2.print())

    println(eval(Sum(Num(1), Multiply(Num(2), Num(3)))).print())

}