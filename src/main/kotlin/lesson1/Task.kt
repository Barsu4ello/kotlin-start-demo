package lesson1

import java.math.BigDecimal
import java.math.RoundingMode

fun main(args: Array<String>) {

}

fun japaneseSalary(base: BigDecimal, years: Int) : BigDecimal {
    require(base > BigDecimal.ZERO) {"Зп должна быть больше 0"}
    return base + 10_000.toBigDecimal() * years.toBigDecimal()
//    return BigDecimal(base.toDouble() + 10_000 * years)
//    return (base.toDouble() + 10_000 * years).toBigDecimal().setScale(0, RoundingMode.HALF_UP)
}

//fun japaneseSalary(base: BigDecimal, years: Int) =  base + 10_000.toBigDecimal() * years.toBigDecimal()
