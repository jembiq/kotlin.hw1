private const val DISCOUNT_30        : Float = 0.30f
private const val DISCOUNT_25        : Float = 0.25f
private const val DISCOUNT_20        : Float = 0.20f
private const val DISCOUNT_15        : Float = 0.15f
private const val EXCLUSIVE_DISCOUNT : Float = 0.05f

fun main() {


    val amount : Int = 3_000
    val total  : Int = 56_000


    val fee = calculateFee(amount = amount, total = total, exclusivity = true)

    print(fee)
}

fun calculateFee(
    amount      : Int,
    total       : Int,
    exclusivity : Boolean = false
) : Float {

    val discount = if(exclusivity) {
        EXCLUSIVE_DISCOUNT
    } else {
        0f
    }

    return when (amount) {
        in      0.. 1_000        -> amount * (1 - (DISCOUNT_30 + discount))
        in      0.. 1_000        -> amount * (1 - (DISCOUNT_30 + discount))
        in  1_001..10_000        -> amount * (1 - (DISCOUNT_25 + discount))
        in 10_001..50_000        -> amount * (1 - (DISCOUNT_20 + discount))
        in 50_001..Int.MAX_VALUE -> amount * (1 - (DISCOUNT_15 + discount))
        else -> total.toFloat()
    }
}

