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
        eventSpecial(date)
        eventBenefit(totalPrice)
    }

    private fun eventBenefit(totalPrice: Int) {
        val benefitDiscountAmount = benefitDiscount(totalPrice)
        val benefitEvent = formatPrice(benefitDiscountAmount)
        if (benefitDiscountAmount != 0) {
            println("증정 이벤트: -${benefitEvent}원")
        }
    }

    private fun eventSpecial(date: Int) {
        val specialDiscountAmount = specialDiscount(date)
        val specialEvent = formatPrice(specialDiscountAmount)
        if (specialDiscountAmount != 0) {
            println("특별 할인: -${specialEvent}원")
        }
    }

    private fun eventWeekend(orderItems: List<OrderMenu>, date: Int) {
        val weekendDiscountAmount = weekendDiscount(orderItems, date)
        val weekendEvent = formatPrice(weekendDiscountAmount)
        if (weekendDiscountAmount != 0) {
            println("주말 할인: -${weekendEvent}원")
        }
    }

    private fun eventWeekday(orderItems: List<OrderMenu>, date: Int) {
        val weekdayDiscountAmount = weekdayDiscount(orderItems, date)
        val weekdayEvent = formatPrice(weekdayDiscountAmount)
        if (weekdayDiscountAmount != 0) {
            println("평일 할인: -${weekdayEvent}원")
        }
    }

    private fun eventChristmas(date: Int) {
        val christmasDiscount = christmasDay(date)
        val christmasEvent = formatPrice(christmasDiscount)
        if (christmasDiscount != 0) {
            println("크리스마스 디데이 할인: -${christmasEvent}원")
        }
    }

    fun totalBenefits(orderItems: List<OrderMenu>, date: Int, totalPrice: Int) {
        println("\n<총혜택 금액>")

        val eventChristmas = christmasDay(date)
        val eventWeekday = weekdayDiscount(orderItems, date)
        val eventWeekend = weekendDiscount(orderItems, date)
        val eventSpecial = specialDiscount(date)
        val eventBenefit = benefitDiscount(totalPrice)

        val totalBenefits = eventBenefit + eventSpecial + eventWeekend + eventWeekday + eventChristmas
        println("-${formatPrice(totalBenefits)}원")
    }

    fun finalPayment(orderItems: List<OrderMenu>, date: Int, totalPrice: Int) {
        println("\n<할인 후 예상 결제 금액>")

        val eventChristmas = christmasDay(date)
        val eventWeekday = weekdayDiscount(orderItems, date)
        val eventWeekend = weekendDiscount(orderItems, date)
        val eventSpecial = specialDiscount(date)

        val totalBenefits = eventSpecial + eventWeekend + eventWeekday + eventChristmas
        val payments = totalPrice - totalBenefits
        println("${formatPrice(payments)}원")
    }

    fun eventBadge(orderItems: List<OrderMenu>, date: Int, totalPrice: Int) {
        println("\n<12월 이벤트 배지>")

        val eventChristmas = christmasDay(date)
        val eventWeekday = weekdayDiscount(orderItems, date)
        val eventWeekend = weekendDiscount(orderItems, date)
        val eventSpecial = specialDiscount(date)
        val eventBenefit = benefitDiscount(totalPrice)

        val totalBenefits = eventBenefit + eventSpecial + eventWeekend + eventWeekday + eventChristmas

        val badge = when {
            totalBenefits >= 20000 -> "산타"
            totalBenefits >= 10000 -> "트리"
            totalBenefits >= 5000 -> "별"
            else -> "없음"
        }
        println(badge)
    }
}