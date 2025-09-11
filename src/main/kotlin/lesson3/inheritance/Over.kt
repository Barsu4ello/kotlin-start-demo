package lesson3.inheritance

interface Clickable {
    fun click()
}

open class RichButton : Clickable {
    override fun click() {}
//    final override fun click() {} //final можно указать на override методе чтобы потомки текущего класса(RichButton) не могли ее переопределить
    open fun disable() {}
    fun focus() {} // без open не унаследовать функцию
}

class AnimatedButton : RichButton() {
    override fun click() {}
    override fun disable() {}
}



abstract class Animated { //abstract открыт для наследования
    abstract fun animate() // нужно переопределить в подклассе(abstract надо писать)
    open fun startAnimate() {} // можно переопределить
//    fun startAnimate() {} // нельзя переопределить (даже если класс абстрактный)
}

class Animator: Animated() {
    override fun animate() {}
    override fun startAnimate() {}
}


fun main() {

}