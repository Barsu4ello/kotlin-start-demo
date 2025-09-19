package lesson11.table.v2

open class Tag(val name: String, val value: String) {

    private val children = mutableListOf<Tag>()
    private val attributes = mutableListOf<Pair<String, String>>()
    fun add(tag: Tag) = children.add(tag)
    fun addAttr(attr: Pair<String, String>) = attributes.add(attr)

    override fun toString(): String {
        return """<$name ${attributes.map{"${it.first} = ${it.second}"}}>$value${children.joinToString(separator = "")}</$name>"""
    }
}

class TABLE(value: String) : Tag("table", value)
class TR(value: String) : Tag("tr", value)
class TD(value: String) : Tag("td", value)

open class TagBuilder {
    var value: String = ""
    var tags: MutableList<Tag> = mutableListOf()
    var attrs: Map<String, String> = mutableMapOf()

    operator fun String.unaryPlus() {
        value = this
    }

    fun attributes(block: Attribute.() -> Unit) {
        val attributes = Attribute().apply(block).map
        attrs = attributes
    }
}

class Attribute {
    val map = mutableMapOf<String, String>()

    infix fun String.to(value: String) {
        map[this] = value
    }
}

class TableBuilder : TagBuilder() {

    fun tr(block: TRBuilder.() -> Unit) {
        val tr = TRBuilder().apply(block).build()
        tags.add(tr)
    }

    fun build(): TABLE = TABLE(value).apply {
        attrs.forEach {
            addAttr(it.toPair())
        }
        tags.forEach {
            add(it)
        }
    }
}

class TRBuilder : TagBuilder() {
    fun td(block: TDBuilder.() -> Unit) {
        val td = TDBuilder().apply(block).build()
        tags.add(td)
    }

    fun build(): TR = TR(value).apply {
        attrs.forEach {
            addAttr(it.toPair())
        }
        tags.forEach {
            add(it)
        }
    }
}

class TDBuilder : TagBuilder() {
    fun build(): TD = TD(value).apply {
        attrs.forEach {
            addAttr(it.toPair())
        }
        tags.forEach {
            add(it)
        }
    }
}

fun table(block: TableBuilder.() -> Unit): TABLE = TableBuilder().apply(block).build()

fun main() {

    val table = table {
        tr {
            attributes {
                "two" to "two"
                "1" to "1"
            }
            td {
                attributes {
                    "one" to "one"
                    "2" to "2"
                }
                +"1"
            }
            td {
                +"2"
            }
            td {
                +"3"
            }
        }
    }

    println(table)
}