package christmas.controller

import christmas.view.InputView
import christmas.view.OutputView

//import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val date = inputView.readDate()
    val orderItems = inputView.receiveOrder()

    outputView.showEventBenefit(date)
    outputView.orderMenu(orderItems)
    outputView.totalOriginalPrice(orderItems)
    outputView.totalGift(orderItems)
}
