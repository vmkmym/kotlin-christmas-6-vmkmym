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
            return price.toString().reversed().chunked(3).joinToString(",").reversed()
        }

        private fun getMenuPrice(menuName: String, menuList: List<Menu>): Int {
            val menu = menuList.find { it.menuName == menuName }
            return menu?.price ?: 0
        }

        fun benefitCondition(totalPrice: Int): String {
            return if (totalPrice >= 120000) {
                "샴페인 1개"
            } else {
                "없음"
            }
        }

        private fun calculateChristmasDiscount(date: Int): Int {
            val baseDiscount = 1000
            val daysUntilChristmas = 25 - date + 1
            val discountAmount = baseDiscount + 100 * (25 - daysUntilChristmas)
            return if (date in 1..25) discountAmount else 0
        }

        fun christmasDay(date: Int): String {
            val discountedChristmas = calculateChristmasDiscount(date)
            return formatPrice(discountedChristmas)
        }

        private fun isWeekday(date: Int): Boolean {
            val weekdays = setOf(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)
            return date in weekdays
        }

        fun weekdayDiscount(orderItems: List<OrderMenu>, date: Int): String {
            val dessertMenu = setOf("초코케이크", "아이스크림")
            val discountPerMenu = 2023
            val discountedWeekday = orderItems.filter { it.name in dessertMenu && isWeekday(date) }
                .sumOf { it.quantity * discountPerMenu }

            return formatPrice(discountedWeekday)
        }

        fun specialDiscount(date: Int, orderItems: List<OrderMenu>): String {
            val specialDiscountDates = setOf(3, 10, 17, 24, 25, 31)
            val discountPerOrder = 1000
            return if (date in specialDiscountDates) {
                formatPrice(discountPerOrder)
            } else {
                "0원"
            }
        }

        fun benefitDiscount(totalPrice: Int): String  {
            return if (totalPrice >= 120000) {
                "25,000원"
            } else {
                "0원"
            }
        }

        fun weekendDiscount(orderItems: List<OrderMenu>, date: Int): Int {
            val discountDates = setOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
            if (date in discountDates) {
                val mainMenus = mainMenuList()
                return mainMenuDiscount(orderItems, mainMenus)
            }
            return 0
        }

        private fun mainMenuDiscount(orderItems: List<OrderMenu>, mainMenus: Set<String>): Int {
            return orderItems.filter { it.name in mainMenus }.sumOf { 2023 * it.quantity }
        }

        private fun mainMenuList(): Set<String> {
            return setOf(
                Menu.T_BONE_STEAK.menuName, Menu.BARBECUE_RIBS.menuName,
                Menu.SEAFOOD_PASTA.menuName, Menu.CHRISTMAS_PASTA.menuName
            )
        }
    }
}

