data class Emp(
    val name: String,
    val age: Int,
    val position: String
)

fun main() {
    val employees = listOf(
        Emp("Max Petrov", 22, "programmer"),
        Emp("Ivan Shapovalov", 33, "analyst"),
        Emp("Semen Deznev", 55, "manager"),
        Emp("Oleg Petrov", 19, "intern"),
        Emp("Katerina Drogova", 31, "programmer"),
        Emp("Nikolay Spivakov", 23, "analyst"),
        Emp("Boris Moiseev", 48, "manager"),
        Emp("Petr Sveshnikov", 37, "programmer"),
        Emp("Maria Kasatonova", 33, "analyst"),
        Emp("Olga Filimonova", 27, "programmer")
    )

    // самый молодой
    println("Самый молодой прогер: ${employees.minBy { it.age }}")
    println("Самый молодой прогер: " + employees.minBy { it.age })
    println("Самый молодой прогер: " + employees.minBy(Emp::age))

    // количество программистов
    println("количество программистов: ${employees.count { it.position == "programmer" }}")

    // распечатать все имена программистов
    println("имена программистов: ${employees.filter { it.position == "programmer" }.map { it.name.split(" ").first() }}")

    // средний возраст
    println("средний возраст: ${employees.map { it.age }.average()}")

    // разделить на две группы - старше 40 и младше
    println("две группы: ${employees.partition { it.age > 40 }}")

    // найти профессию самого старого из молодых
    println(
        "Профессия самого старого из молодых : ${
            employees.partition { it.age > 40 }.second.maxBy { it.age }.position
        }"
    )

    // сгруппировать по профессии и распечатать профессию и количество работников в ней
    println("группировка: ")
    employees.groupBy { it.position }.forEach { (position, listEmp) -> println("$position : ${listEmp.size}") }

    // вернуть в виде пары средний возраст женщин и мужчин
    val (women, men) = employees.partition { it.name.endsWith("va") }
    println(
        "Средний возраст в виде пары женщин и мужчин: ${
            Pair(
                women.map { it.age }.average(),
                men.map { it.age }.average()
            )
        }"
    )

    // распечатать работников с самым часто встречающимся возрастом
    val empOftenAge = employees.groupBy { it.age }.maxBy { it.value.size }.value
    println("Работники с самым часто встречающимся возрастом: $empOftenAge")

    // пара работников с самой большой разницей в возрасте
    val maxDifferentAge = Pair(employees.minBy { it.age }, employees.maxBy { it.age })
    println("Пара работников с самой большой разницей в возрасте: $maxDifferentAge")
}