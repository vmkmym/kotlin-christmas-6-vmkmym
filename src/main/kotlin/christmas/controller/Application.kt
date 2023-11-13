package christmas.controller

import christmas.view.InputView
import christmas.view.OutputView

//import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    // 식당 방문 날짜
    val date = inputView.readDate()
    // 주문할 메뉴
    val orderItems = inputView.receiveOrder()
    // 총 주문 금액
    val totalPrice: Int = outputView.totalOriginalPrice(orderItems)


    // 이벤트 혜택 미리보기
    outputView.showEventBenefit(date)
    // 주문 메뉴
    outputView.orderMenu(orderItems)
    // 할인 전 총 주문 금액
    outputView.totalOriginalPrice(orderItems)
    // 증정 메뉴
    outputView.totalGift(orderItems)
    // 혜택 내역
    outputView.totalDiscount(date, orderItems, totalPrice)
}
