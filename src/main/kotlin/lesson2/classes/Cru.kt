package lesson2.classes

enum class Cru(val lvl: Int) {
    CRU(80),
    PREMIER(90),
    GRAND(100);

    override fun toString() =
        when (this) {
            CRU -> "Base vine"
            PREMIER -> "Premier vine"
            GRAND -> "Grand vine"
        }

}

fun main() {
//    println("lesson1And2.Cru: ${lesson1And2.Cru.CRU.lvl}")
//    println("PREMIER: ${lesson1And2.Cru.PREMIER.lvl}")
//    println("Grand: ${lesson1And2.Cru.GRAND.lvl}")
//    println(lesson1And2.Cru.GRAND)
//    println("Grand: ${lesson1And2.Cru.GRAND.lvl}")
//    println(lesson1And2.Cru.GRAND)

    Cru.entries.forEach { println(it) }


}