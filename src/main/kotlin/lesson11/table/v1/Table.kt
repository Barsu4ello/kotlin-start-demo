package lesson11.table.v1

class Table(val tr: TrObject) {
    override fun toString(): String {
        return "<table>\n$tr\n</table>"
    }
}

data class TrObject(var td: List<TdObject>) {
    override fun toString(): String {
        return "<tr>\n${td.joinToString(separator = "") }\n</tr>"
    }
}

data class TdObject(val value: String) {
    override fun toString(): String {
        return "<td>${value}</td>"
    }
}

class TableBuilder {
    lateinit var tr: TrObject

    fun tr(block: TrBuilder.() -> Unit) {
        tr = TrBuilder().apply(block).build()
    }


    fun build() = Table(tr)
}

class TrBuilder {
    var td: MutableList<TdObject> = mutableListOf()

    fun td(block: () -> Unit) = block()

    operator fun String.unaryPlus() = td.add(TdObject(this))

    // обертка над модифицируемым листом (но ее даже не кастануть будет к MutableList или к реальному типу UnmodifiableCollection и тд, ибо у них package модификатор доступа)
//    fun build() = TrObject(td.toImmutableList()) // + это из okhttp3.internal.toImmutableList а это не стандартная библиотека
    fun build() = TrObject(td.toList()) // тоже обертка
}


fun table(block: TableBuilder.() -> Unit): Table = TableBuilder().apply(block).build()

fun main() {

    val t = table {
        tr {
            td {
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

    println(t)
}