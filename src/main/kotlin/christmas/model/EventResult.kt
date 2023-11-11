package christmas.model


data class EventResult(
    val orderMenu: List<Menu>,
    val totalOriginalPrice: Int,
    val totalDiscount: Int,
    val totalGift: Menu?,
    val totalBenefits: Int,
    val finalPayment: Int,
    val eventBadge: String
)