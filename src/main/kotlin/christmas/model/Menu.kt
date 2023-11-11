package christmas.model


enum class Menu(val menuName: String, val price: Int) {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5000),
    CAESAR_SALAD("시저샐러드", 8000),

    T_BONE_STEAK("티본스테이크", 55000),
    BARBECUE_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),

    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000),

    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    companion object {
        fun isValidMenu(menuName: String): Boolean {
            return Menu.values().any { it.menuName == menuName }
        }

        fun validateQuantity(quantity: Int) {
            if (quantity <= 0) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            }
        }

        fun maxQuantity(quantity: Int) {
            if (quantity >= 20) {
                throw IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.")
            }
        }

        fun validateMenuFormat(menu: String) {
            if (!menu.matches(Regex("[a-zA-Z]+-[0-9]+"))) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            }
        }

//        fun checkOnlyDrink(orderedItems: Map<String, Int>): Boolean {
//            val drinkItems = orderedItems.filter { isDrink(it.key) }
//            return drinkItems.size == orderedItems.size
//        }
    }
}