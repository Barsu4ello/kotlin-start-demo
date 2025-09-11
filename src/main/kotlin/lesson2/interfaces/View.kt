package lesson2.interfaces

interface View {
    fun click() = println("Click on view")
    fun whoAmI() = println("I am view")
}

interface Shape {
    fun whoAmI() = println("I am shape")
}

class Button : TextView(), View, Shape {
//    override fun click() = println("Button click")
//    override fun whoAmI() = println("I am button")
    override fun whoAmI() {
        super<View>.whoAmI()
        super<Shape>.whoAmI()
    }
}

open class TextView : View {
    override fun click() = println("TextView click")
    override fun whoAmI() = println("I am textView")
}

fun main() {
    val v1:View = Button()
    val v2:View = TextView()
    v1.whoAmI()
    v2.whoAmI()
    v1.click()
//    val button = Button()
//    button.click()
//    button.whoAmI()
}