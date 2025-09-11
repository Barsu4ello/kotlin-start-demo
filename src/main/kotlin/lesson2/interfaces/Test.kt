package lesson2.interfaces

interface Test {
    val count2: Int
    val count: Int  // только геттер — абстрактный, надо реализовать в классе
        get() = 100
    var name: String
        get() = "Default"  // геттер с реализацией
        set(value) {}
}

class Testimpl(override var count2: Int) : Test {


}