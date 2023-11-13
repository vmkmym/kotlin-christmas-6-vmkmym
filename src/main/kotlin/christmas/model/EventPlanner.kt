package christmas.model

class EventPlanner {
    companion object {
        fun orderFormat(orderItems: List<OrderMenu>): List<Pair<String, Int>> {
            return orderItems.map { it.name to it.quantity }
        }

        fun checkDate(date: Int) {
            if (date !in 1..31) {
                throw NumberFormatException()
            }
        }

        fun isValidInput(menuItems: List<OrderMenu>): Boolean {
            return menuItems.isNotEmpty()
        }

        fun parseOrderInput(input: String): List<OrderMenu> {
            val orderItems = input.split(",").map { it.trim() }
            return orderItems.map { parseMenuItem(it) }
        }

        private fun parseMenuItem(item: String): OrderMenu {
            val parts = item.split("-")
            if (parts.size != 2) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            }
            return OrderMenu(parts[0], parts[1].toInt())
        }

        fun calculateTotalPrice(orderItems: List<OrderMenu>, menuList: List<Menu>): Int {
            return orderItems.sumOf { getMenuPrice(it.name, menuList) * it.quantity }
        }

        fun formatPrice(price: Int): String {
            val formattedPrice = price.toString().reversed().chunked(3).joinToString(",").reversed()
            return "${formattedPrice}원"
        }

        fun getMenuPrice(menuName: String, menuList: List<Menu>): Int {
            val menu = menuList.find { it.menuName == menuName }
            return menu?.price ?: 0
        }

        fun benefitCondition(totalPrice: Int) {
            if (totalPrice >= 120000) {
                println("샴페인 1개")
            } else {
                println("없음")
            }
        }

        fun calculateChristmasDiscount(date: Int): Int {
            val baseDiscount = 1000
            val daysUntilChristmas = 25 - date
            val discountAmount = baseDiscount + 100 * (25 - daysUntilChristmas)
            return if (date in 1..25) discountAmount else 0
        }

        fun christmasDC(date: Int): String {
            val discountAmount = calculateChristmasDiscount(date)
            return "${formatPrice(discountAmount)}원"

        }


    }
}

