package lesson4

import javax.print.attribute.standard.MediaSize.Other

//аналог синглтона
object Singleton {
    var name: String = "Dima"
    fun hello() = println("Hello")
}

// объект компаньон(1 на класс) Заменяет статические методы
class Outer {

    private constructor()

    // Можно давать имя(по умолчанию Companion), чтобы избежать конфликта например с полями
    // Но врятли ты назовешь свойство Companion с большой буквы
    companion object {
        fun hello() = println("Hello companion object")
        fun get() = Outer()
    }
}

interface ClickListener {
    fun click()
}

class View {
    fun setInClickListener(listener: ClickListener) {

    }
}


fun main() {
    //аналог синглтона
    println(Singleton.name)
    Singleton.hello()

    Outer.hello()
//    val outer2 = Outer() // приватный конструктор, но можно через метод команьона(он имеет доступ как внутренний класс)
    val outer = Outer.get()

    //анонимный класс
    val view = View()
    view.setInClickListener(object  : ClickListener {
        override fun click() {
            TODO("Not yet implemented")
        }
    })

    val listener = object : ClickListener {
        override fun click() {
            TODO("Not yet implemented")
        }
    }
    view.setInClickListener(listener)
}