package lesson1

//Shift + alt + x
fun main(args: Array<String>) {
    println(test(""))
//    firstName = "";
    lastName = "";
    println(age?.javaClass)
}


fun main2(args: Array<String>) {
    println("Hello Kotlin!");

}

val test: (String) -> String = { _ -> "Hello Kotlin!" }
//val test: Function<String, String> = Function { "Hello Kotlin!" }

val firstName: (String) = "Masha" // val = final
var lastName: (String) = "Ivanova" // var значит что изменяемый объект
var age: Int? = 1
//const val age1: List<String> = List(1, { firstName }); // const работает только с примитивами и  String

