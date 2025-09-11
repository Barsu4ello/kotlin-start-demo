package lesson4.kotlinLambda


data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31), Person("Carol", 31))

fun hi() = println("hi")

fun Person.isAdult() = age >= 18

fun main() {

    val ageSort = { p: Person -> p.age }
    println(ageSort(people[1]))
    people[1].run(ageSort)
    //ссылка на метод класса (выглядит как на ссылка на свойство, но по факту на getAge())
    val ageSortMethod = Person::age
    println(ageSortMethod(people[1]))
    people[1].run(ageSortMethod)
    //Ссылка на глобальную функцию(public final static hi())
    val hello = ::hi
    hello()
    run(hello)

    //ссылка на конструктор
    val create = ::Person
    println(create("Max", 19))

    // ссылка на функцию расширения
    val adult = Person::isAdult
    println(adult(people[0]))

    // ссылка на метод конкретного экземпляра
    val peopleOneAge = people[1]::age
    println("peopleOneAge ${peopleOneAge()}")

    //minBy ищет мин (или если maxBy то макс) объект по какому-то Comparable свойству)
    //4 одинаковые записи
//    val minBy = people.minBy( { p: Person -> p.age } )
//    val minBy = people.minBy() { p: Person -> p.age }
//    val minBy = people.minBy { p: Person -> p.age }
//    val minBy = people.minBy { p -> p.age }
//    val minBy = people.minBy ( Person::age )
//    val minBy = people.minBy(ageSortMethod)
//    val minBy = people.minBy(ageSort)
    val minBy = people.minBy { it.age }
    println(minBy)


    val sum = { x: Int, y: Int ->
        println("Computing $x and $y")
        x + y  // возвращается из лямбды последняя строка
    }

    println(sum(10, 10))

    //заметь что можно менять не final переменную. А в java так нельзя
    var counter = 0
    people.forEach { counter++ }
    println(counter)
}