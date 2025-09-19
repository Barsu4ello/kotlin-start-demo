package lesson11.person.v2


data class Person(val name: String, val age: Int = 0, val address: Address)

data class Address(val street: String, val number: Int, val city: String)

fun person(block: PersonBuilder.() -> Unit): Person = PersonBuilder().apply(block).build()

fun PersonBuilder.address(block: AddressBuilder.() -> Unit) {
    this.address = AddressBuilder().apply(block).build()
}


class PersonBuilder {

    var name = ""
    var age = 0
    lateinit var address: Address
//    var address: Address? = null

    // также как и в случае с изменяемыми полями в версии v1 можно сделать или функцию расширения для PersonBuilder или написать функцию внутри класса
//    fun address(block: AddressBuilder.() -> Unit) {
//        this.address = AddressBuilder().apply(block).build()
//    }

    fun build() = Person(name, age, address)
//    fun build() = Person(name, age, address!!) // если без lateinit
}

class AddressBuilder {
    var street = ""
    var number = 0
    var city = ""

    fun build() = Address(street, number, city)
}

fun main() {

    val person = person {
        name = "John"
        age = 24
        address {
            street = "Leninsky prosp"
            number = 42
            city = "Moscow2"
        }
    }

    println(person)
}