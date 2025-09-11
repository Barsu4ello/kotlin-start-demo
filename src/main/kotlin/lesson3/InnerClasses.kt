package lesson3

class Outer {
    //похоже на static в java
    class Nested {

    }
    //похоже на не static в java
    inner class Internal{
        fun getOuter(): Outer = this@Outer
    }
}

fun main() {
    val outer = Outer()
    val nested = Outer.Nested()
    val internal = outer.Internal()


    testBober()
}

fun testBober() {
    class Bober {
        fun foo() {
            println("Bober foo")}
    }
    val nestedBober = Bober()
    nestedBober.foo()
}

