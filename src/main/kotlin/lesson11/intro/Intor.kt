package lesson11.intro


class Student(var name: String, var age: Int) {
    val nickname: MutableList<String> = mutableListOf()

    operator fun String.unaryPlus() {
        nickname += this
    }
}

fun Student.add(addedValue: Int): Student {
    age += addedValue
    return this
}

operator fun Student.plus(addedValue: Int): Student {
    age += addedValue
    return this
}

fun abc(i: (Int) -> Int): Int = i.invoke(1)

//fun student(block: Student.() -> Unit): Student {
//    var result = Student("", 0)
//    result.block()
//    return result
//}

// то же что и выше но в одну строку
fun student(block: Student.() -> Unit): Student = Student("", 0).apply(block)

operator fun Student.plus(newNick: String) = { nickname += newNick }

fun main() {

    val student1 = Student("John Smith", 17)
    println(student1.add(16).age)
    println((student1 + 16).age)

    val student2 = student {
        name = "John Smith"
        age = 17

        +"red"
    }

    println("${student2.name} ${student2.age} ${student2.nickname}")

}