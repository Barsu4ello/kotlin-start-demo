package lesson4.tasks

class Hedgehog {
    fun whoAmI() {
        println("Hedgehog")
    }
}

class Snake {
    fun whoAmI() {
        println("Snake")
    }
}

class Barbwire(val hedgehog: Hedgehog, val snake: Snake) {
    fun whoAmI(): Unit {
        hedgehog.whoAmI()
        snake.whoAmI()
    }
}

operator fun Hedgehog.plus(snake: Snake): Barbwire = Barbwire(this, snake)

fun main() {
    val hedgehog = Hedgehog()
    val snake = Snake()
    val barbwire = hedgehog + snake
    println(barbwire.whoAmI())
}