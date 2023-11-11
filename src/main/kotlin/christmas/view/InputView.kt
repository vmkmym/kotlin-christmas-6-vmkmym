package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.Menu.Companion.isDrink
import christmas.model.Menu.Companion.isValidMenu
import christmas.model.Menu.Companion.maxQuantity
import christmas.model.Menu.Companion.validateMenuFormat
import christmas.model.Menu.Companion.validateQuantity

class InputView {
    fun readDate(): Int {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")

        while (true) {
            println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
            val input = Console.readLine()

            try {
                val date = input.toInt()
                if (date in 1..31) {
                    readOrder()
                    return date
                }
            } catch (_: NumberFormatException) {
            }

            println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    private fun readOrder(): Map<String, Int> {
        while (true) {
            try {
                println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
                val input = Console.readLine()
                return checkOrderInput(input)
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            }
        }
    }


    private fun checkOrderInput(input: String): Map<String, Int> {
        val orderedItems = mutableSetOf<Pair<String, Int>>()

        return input.split(",").associate {
            val (menu, quantity) = it.split("-")
            val order = Pair(menu, quantity.toInt())

            if (!orderedItems.add(order)) {
                throw IllegalArgumentException("[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요.")
            }

            if (!isValidMenu(menu)) {
                throw IllegalArgumentException("[ERROR] 메뉴 이름이 유효하지 않습니다. 다시 입력해 주세요.")
            }


            validateOrder(menu, quantity.toInt())
            order.first to order.second
        }


    }


    private fun validateOrder(menu: String, quantity: Int) {
        isValidMenu(menu)
        validateQuantity(quantity)
        maxQuantity(quantity)
        validateMenuFormat(menu)
        isDrink(menu)
    }


}