package lesson4

open class Base

class Child : Base()

// функции расширения не наследуются
// Так как они статические -> Статические вызываются на классе -> И они всегда будут вызываться на том классе, на типе которого объект создан
// Это как вызвать в java Base.hello(). Тут не нужен объект, а то есть от него и не зависит какой метод вызовится
fun Base.hello() = "Hello base ${this.javaClass.simpleName}"

fun Child.hello() = "Hello child ${this.javaClass.simpleName}"

fun main() {
    val child: Base = Child()
    val base: Base = Base()

    println(child.hello())
    println(base.hello())
}