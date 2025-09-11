package lesson4

data class Point(val x: Int, val y: Int) {
    operator fun plus(point2: Point): Point {
        return Point(x + point2.x, y + point2.y)
    }
}

class Rect(val upperLeft: Point, val lowerRight: Point)

operator fun Rect.contains(p: Point): Boolean = p.x in upperLeft.x .. lowerRight.x && p.y in upperLeft.y .. lowerRight.y

// переопределение операторов + и * в классе
data class RelationNumber(val numerator: Int, val denominator: Int) {
//    operator fun plus(other: RelationNumber): Double =
//        (numerator * other.denominator + denominator * other.numerator) / (denominator * other.denominator).toDouble()

    operator fun times(other: RelationNumber): Double =
        (numerator * other.numerator) / (denominator * other.denominator).toDouble()

    // для получение через [1] как по индексу в листе
    operator fun get(ind: Int): Int = if (ind == 0) numerator else denominator

}

// переопределение операторов + и * в классе в функциях расширения
operator fun RelationNumber.plus(other: RelationNumber): RelationNumber =
    RelationNumber(numerator * other.denominator + denominator * other.numerator, denominator * other.denominator)

// на вход могут любые типы преходить и можно перегружать
operator fun RelationNumber.plus(other: Double): Double = numerator + other

// если мы хотим отрицательное НЕЧТО сделать типо -5 но с объектом
operator fun RelationNumber.unaryMinus(): RelationNumber = RelationNumber(-numerator, -numerator)

fun main() {
    val point1 = Point(10, 20)
    val point2 = Point(30, 30)

//    val point = point1.plus(point2)
    val point = point1 + point2
    println(point)

    val rect = Rect(Point(4, 4), Point(20, 10))
    //contains
    println(Point(3, 3) in rect)
    println(rect.contains(Point(3, 3)))
    //contains
    println(Point(5, 5) in rect)
    println(rect.contains(Point(5, 5)))

    val relationNumber1 = RelationNumber(3, 7)
    val relationNumber2 = RelationNumber(12, 11)

    println(relationNumber1 + relationNumber2)
    println(relationNumber1 * relationNumber2)
    println(relationNumber1 + 12.0)
    println(-relationNumber1)

    var a = -5
    val b = 3
    a += b
    println(a % b)   // -2
    println(a.mod(b))//  1 // тут у Gpt можешь спросить он покажет используй %

    println("numerator ${relationNumber1[0]}")
    println("denominator ${relationNumber1[1]}")

}