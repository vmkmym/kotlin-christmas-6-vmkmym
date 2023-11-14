package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.EventPlanner.Companion.checkDate
import christmas.model.EventPlanner.Companion.isValidInput
import christmas.model.EventPlanner.Companion.parseOrderInput
import christmas.model.OrderMenu
import christmas.utils.ErrorHandler
import christmas.utils.ErrorHandler.Companion.checkReceiveOrder


class InputView {
    fun readDate(): Int {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
        while (true) {
            println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
            try {
                val input = Console.readLine()
                val date = input.toInt()
                checkDate(date)
                return date
            } catch (_: NumberFormatException) {
                println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
            }
        }
    }

    fun receiveOrder(): List<OrderMenu> {
        while (true) {
            println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
            try {
                val input = Console.readLine()
                val menuItems = parseOrderInput(input)

                checkReceiveOrder(menuItems)

                if (isValidInput(menuItems)) return menuItems
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: IndexOutOfBoundsException) {
                println(e.message)
            }
        }
    }
}