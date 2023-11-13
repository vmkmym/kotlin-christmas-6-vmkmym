package christmas.view

import christmas.model.EventPlanner
import christmas.model.EventPlanner.Companion.benefitCondition
import christmas.model.EventPlanner.Companion.benefitDiscount
import christmas.model.EventPlanner.Companion.calculateTotalPrice
import christmas.model.EventPlanner.Companion.christmasDay
import christmas.model.EventPlanner.Companion.formatPrice
import christmas.model.EventPlanner.Companion.specialDiscount
import christmas.model.EventPlanner.Companion.weekdayDiscount
import christmas.model.EventPlanner.Companion.weekendDiscount
import christmas.model.Menu
import christmas.model.OrderMenu


class OutputView {
    val inputView = InputView()
    fun showEventBenefit(date: Int) {
        println("12월 ${date}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun orderMenu(orderItems: List<OrderMenu>) {
        println("\n<주문 메뉴>")
        val formattedOrders = EventPlanner.orderFormat(orderItems)
        for ((menu, quantity) in formattedOrders) {
            println("$menu ${quantity}개")
        }
    }

    fun totalOriginalPrice(orderItems: List<OrderMenu>): Int {
        println("\n<할인 전 총주문 금액>")
        val totalPrice = calculateTotalPrice(orderItems, Menu.entries)
        val formattedTotalPrice = formatPrice(totalPrice)
        println(formattedTotalPrice)
        return totalPrice
    }

    fun totalGift(orderItems: List<OrderMenu>) {
        println("\n<증정 메뉴>")
        val totalPrice = calculateTotalPrice(orderItems, Menu.entries)
        val benefitResult = benefitCondition(totalPrice)
        println(benefitResult)
    }

    fun totalDiscount(date: Int, orderItems: List<OrderMenu>, totalPrice: Int) {
        println("\n<혜택 내역>")
        eventChristmas(date)
        eventWeekday(orderItems, date)
        eventWeekend(orderItems, date)
        eventSpecial(date, orderItems)
        eventBenefit(totalPrice)
    }

    private fun eventBenefit(totalPrice: Int) {
        val benefitDiscountAmount = benefitDiscount(totalPrice)
        if (benefitDiscountAmount != "0원") {
            println("증정 이벤트: -$benefitDiscountAmount")
        }
    }

    private fun eventSpecial(date: Int, orderItems: List<OrderMenu>) {
        val specialDiscountAmount = specialDiscount(date, orderItems)
        if (specialDiscountAmount != "0원") {
            println("특별 할인: -${specialDiscountAmount}원")
        }
    }

    private fun eventWeekend(orderItems: List<OrderMenu>, date: Int) {
        val weekendDiscountAmount = weekendDiscount(orderItems, date)
        if (weekendDiscountAmount != 0) {
            println("주말 할인: -${weekendDiscountAmount}원")
        }
    }

    private fun eventWeekday(orderItems: List<OrderMenu>, date: Int) {
        val weekdayDiscountAmount = weekdayDiscount(orderItems, date)
        if (weekdayDiscountAmount != "0원") {
            println("평일 할인: -${weekdayDiscountAmount}원")
        }
    }

    private fun eventChristmas(date: Int) {
        val christmasDiscount = christmasDay(date)
        if (christmasDiscount != "0원") {
            println("크리스마스 디데이 할인: -${christmasDay(date)}원")
        }
    }


    fun totalBenefits() {
        // 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
        // 4가지 할인 금액 더하기
        println("\n<총혜택 금액>")
//        println("${}원")
    }

    fun finalPayment() {
        // getTotalOrderAmount - showTotalBenefitAmout
        println("\n<총주문 금액>")
//        println("${}원")
    }

    fun eventBadge() {
        println("\n<12월 이벤트 배지>")
        // 이벤트 배지가 부여되지 않는 경우, "없음"으로 보여 주세요.
        // 총혜택 금액에 따라 다른 이벤트 배지를 부여합니다.
        // 5천 원 이상: 별
        // 1만 원 이상: 트리
        // 2만 원 이상: 산타
    }

}