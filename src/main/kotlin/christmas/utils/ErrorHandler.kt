package christmas.utils

import christmas.model.Menu
import christmas.model.OrderMenu

class ErrorHandler {
    companion object {
        fun checkReceiveOrder(menuItems: List<OrderMenu>) {
            menuItems.forEach { (menuName, quantity) ->
                isValidMenu(menuName)
                minQuantity(quantity)
            }
            maxQuantity(menuItems)
            checkBeverageOnly(menuItems)
        }
        private fun isValidMenu(menuName: String) {
            if (Menu.entries.toTypedArray().none { it.menuName == menuName }) {
                throw IllegalArgumentException("[ERROR] 메뉴 이름이 유효하지 않습니다. 다시 입력해 주세요.")
            }
        }

        private fun minQuantity(quantity: Int) {
            if (quantity <= 0) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            }
        }

        private fun maxQuantity(menuItems: List<OrderMenu>) {
            val totalQuantity = menuItems.sumOf { it.quantity }
            if (totalQuantity > 20) {
                throw IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.")
            }
        }


//        private fun maxQuantity(quantity: Int) {
//            if (quantity > 20) {
//                throw IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.")
//            }
//        }

        private val beverageCategories = setOf("제로콜라", "레드와인", "샴페인")

        private fun isBeverage(menuName: String): Boolean {
            return menuName in beverageCategories
        }

        private fun checkBeverageOnly(menuList: List<OrderMenu>) {
            val hasBeverage = menuList.any { (menuName, _) -> isBeverage(menuName) }
            val hasOtherItems = menuList.any { (menuName, _) -> !isBeverage(menuName) }

            if (hasBeverage && !hasOtherItems) {
                throw IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요.")
            }
        }
    }
}
