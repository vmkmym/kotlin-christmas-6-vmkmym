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
}

//companion object {
//    fun isValidMenu(menuName: String) {
//        if (Menu.entries.toTypedArray().none { it.menuName == menuName }) {
//            throw IllegalArgumentException("[ERROR] 메뉴 이름이 유효하지 않습니다. 다시 입력해 주세요.")
//        }
//    }
//
//    fun minQuantity(quantity: Int) {
//        if (quantity <= 0) {
//            throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
//        }
//    }
//
//    fun maxQuantity(quantity: Int) {
//        if (quantity >= 20) {
//            throw IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.")
//        }
//    }
//
//    private val beverageCategories = setOf("제로콜라", "레드와인", "샴페인")
//
//    private fun isBeverage(menuName: String): Boolean {
//        return menuName in beverageCategories
//    }
//
//    fun checkBeverageOnly(menuList: List<Pair<String, Int>>) {
//        val hasBeverage = menuList.any { (menuName, _) -> isBeverage(menuName) }
//        val hasOtherItems = menuList.any { (menuName, _) -> !isBeverage(menuName) }
//
//        if (hasBeverage && !hasOtherItems) {
//            throw IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요.")
//        }
//    }
//}