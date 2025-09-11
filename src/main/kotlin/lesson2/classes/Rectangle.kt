package lesson2.classes

class Rectangle(val height: Int, val width: Int) {

    val isSquare: Boolean
        get() = height == width

    val area: Int
        get() = height * width

    var depth: Int = 1
        get() = field * 100
        set(value) { field = value / 100 }

}

fun main() {
    println(Rectangle(5, 5).isSquare)
    println(Rectangle(5, 4).isSquare)

    println(Rectangle(5, 5).area)
    println(Rectangle(5, 4).area)

    val rectangle = Rectangle(5, 5)
    println(rectangle.depth)
    rectangle.depth = 12000
    println(rectangle.depth)




}