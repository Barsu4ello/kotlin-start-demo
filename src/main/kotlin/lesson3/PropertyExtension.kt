package lesson3

import java.lang.StringBuilder

val StringBuilder.lastCharTest: Char
    get() = get(length - 1)