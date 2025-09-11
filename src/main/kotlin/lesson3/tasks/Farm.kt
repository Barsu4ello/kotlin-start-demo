package lesson3.tasks

interface Sayable { fun say() }

class Goat: Sayable { override fun say() {println("Goat!") }}
class Cow: Sayable { override fun say() {println("Cow!") }}
class Dog: Sayable { override fun say() {println("Dog!") }}

fun main() {
    val goat = Goat()
    val cow = Cow()
    val dog = Dog()

    val list = listOf(goat, cow, dog)
    list.forEach { it.say() }
}