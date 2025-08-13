package ru.netology

import kotlin.math.roundToInt

const val DISCOUNT_RATE_5 = 0.05
const val DISCOUNT_MIN = 100.0
const val DISCOUNT_RATE_REG = 0.01

fun main() {
    val amounts = listOf(500.0, 1000.0, 15_000.0, 100_000.0, 1000_000.0)

    for ((index, amount) in amounts.withIndex()) {

        val isRegularCust = if (index % 2 == 0) true else false
        val regularCustStr = if (isRegularCust) "постоянной" else ""

        val baseDisc = amount - discountByIf(amount)
        val amountDisc = if (isRegularCust) (baseDisc - baseDisc * DISCOUNT_RATE_REG).roundToInt()
        else baseDisc.roundToInt()

        println("Цена: $amount руб., с учетом $regularCustStr скидки: $amountDisc руб.")
    }
}

fun discountByIf(amount: Double): Double {
    val discount = if (amount > 10_000) {
        amount * DISCOUNT_RATE_5
    } else if (amount >= 1000 && amount <= 10_000) {
        DISCOUNT_MIN
    } else {
        0.0
    }
    return discount
}

fun discountByWhen(amount: Double): Double {
    val discount = when {
        amount in 1000.0..10_000.0 -> DISCOUNT_MIN
        amount > 10_000.0 -> amount * DISCOUNT_RATE_5
        else -> 0.0
    }
    return discount
}