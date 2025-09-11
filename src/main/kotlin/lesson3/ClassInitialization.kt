package lesson3

//Инициализация происходит через первичный конструктор
//class User(val name: String) {

//аналогично, НО через вторичный конструктор
//Вторичных конструкторов может быть несколько(обычно не используется. Достаточно одного конструктора с дефолтными параметрами)
//class User {
//    val name:String
//    constructor(name:String) {
//        this.name = name
//    }
//}

// По сути просто в конструкторе будет не this.name = name а name = _name
//class User(_name:String) {
//    val name:String = _name
//}

//аналогично, НО через вторичный конструктор
//Вторичных конструкторов может быть несколько(обычно не используется. Достаточно одного конструктора с дефолтными параметрами)
//class User {
//    val name: String
//
//    constructor(name: String) : super() {
//        this.name = name
//    }
//}


open class Base {
    init {
        println("Base")
    }
}

// можно иметь и Primary и Secondary конструкторы. Тогда вторичный должен вызвать первичный
class User: Base {
    val name:String
    constructor(name:String) { // super() можно опустить если базовый класс имеет пустой конструктор
        println("constructor")
        this.name = name
    }

//    constructor(age:Int) : this("name") {
//        println("constructor")
//    }

    //как статический блок через компаньона
    companion object {
        init {
            println("Static init block - выполняется при загрузке класса")
        }
    }

    init {
        println("User constructor")
    }
}

// приватный конструктор
class Secret {
    private constructor()
}

// data дает toString, equals, hashCode ,componentN для деструктуризации, copy
//причем крутой copy типо;
//fun copy(name: String = this.name, index: Int = this.index) = Client(name, index)
//то есть можно какие-то свойства переопределить
data class Client(val name:String, val index: Int) {
//    override fun toString(): String = "Name: $name, index: $index"
//    override fun equals(other: Any?): Boolean {
////        if (other == null ) return false // тут сам думай по логике класса нормально ли null === null чтобы было true или false
//        if (this === other) return true
//        if (other !is Client) return false
//        return name == other.name && index == other.index
//    }
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + index
//        return result
//    }
}

fun main() {
    val user = User("test")

    var misha1: Client? = Client("misha", 112112)
    var misha2: Client? = Client("misha", 112112)
    var mashsa: Client? = Client("misha", 112112)
    println(misha1)
    println(misha1 == misha2)
    val vasya = mashsa?.copy(name = "vasya")
    println(vasya)
    var (name, index) = vasya!!
    println(name)
    println(index)
    // Если при деструктуризации нам какое-то свойство не нужно то пишем _
    var (_, index2) = vasya
    println(index2)
    //или
    val  index3 = vasya.component2()

//    misha1 = null
//    misha2 = null
//    println(misha1 == misha2)

    val set = hashSetOf(misha1) // обрати внимание что setOf имеет странную реализацию
        // если 0 элементов это EmptySet, а если 1 - то SingletonSet а там сравнение идет по equals
    // это не касается mutableSet (но в нем будет LinkedHashSet)
    println(misha1.hashCode())
    println(mashsa.hashCode())
    println(set.contains(mashsa))


}

