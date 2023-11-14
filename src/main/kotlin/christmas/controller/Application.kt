package christmas.controller

import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    // 식당 방문 날짜
    val date = inputView.readDate()
    // 주문할 메뉴
    val orderItems = inputView.receiveOrder()


    // 이벤트 혜택 미리보기
    outputView.showEventBenefit(date)
    // 주문 메뉴
    outputView.orderMenu(orderItems)
    // 할인 전 총 주문 금액
    val totalPrice = outputView.totalOriginalPrice(orderItems)
    // 증정 메뉴
    outputView.totalGift(orderItems)
    // 혜택 내역
    outputView.totalDiscount(date, orderItems, totalPrice)
    // 총 혜택 금액
    outputView.totalBenefits(orderItems, date, totalPrice)
    // 할인 후 예상 금액
    outputView.finalPayment(orderItems, date, totalPrice)
    // 12월 이벤트 배지
    outputView.eventBadge(orderItems, date, totalPrice)
}
