package lesson11.person.v1


data class Person(var name: String = "", var age: Int = 0, var address: Address = Address()) {
    fun address(block: Address.() -> Unit): Unit {
        address = Address().apply(block)
    }
}

data class Address(var street: String = "", var number: Int = 0, var city: String = "")

fun person(block: Person.() -> Unit): Person = Person().apply(block)

// Так показали на курсе но и функция внутри Person работает. Так что тут видимо как удобнее
//fun Person.address(block: Address.() -> Unit): Unit {
//    this.address = Address().apply(block)
//}

fun main() {

    val person = person {
        name = "John"
        age = 24
        address {
            street = "Leninsky prosp"
            number = 42
            city = "Moscow"
        }
    }

    println(person)
}