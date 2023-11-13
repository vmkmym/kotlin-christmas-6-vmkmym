package christmas.view

import christmas.model.EventPlanner
import christmas.model.EventPlanner.Companion.formatPrice
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

    fun totalOriginalPrice(orderItems: List<OrderMenu>) {
        println("\n<할인 전 총주문 금액>")
        val totalPrice = EventPlanner.calculateTotalPrice(orderItems, Menu.entries)
        val formattedTotalPrice = formatPrice(totalPrice)
        println(formattedTotalPrice)
    }

    fun totalGift(orderItems: List<OrderMenu>) {
        println("\n<증정 메뉴>")
        val totalPrice = EventPlanner.calculateTotalPrice(orderItems, Menu.entries)
        EventPlanner.benefitCondition(totalPrice)
    }

    fun totalDiscount() {
        println("\n<혜택 내역>")
//        println("\n크리스마스 디데이 할인: -${EventPlanner.christmasDC(date = )}")
//        println("\n평일 할인: -${}원")
//        println("\n특별 할인: -${}원")
//        println("\n증정 이벤트: -${}원")

        // 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
        // 고객에게 적용된 이벤트 내역만 보여 주세요.
        // 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
        // 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.

        // 크리스마스 디데이 할인
            // 이벤트 기간: 2023.12.1 ~ 2023.12.25
            // 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
            // 총주문 금액에서 해당 금액만큼 할인
            // (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)

        // 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
        // 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
        // 특별 할인: 이벤트 달력에 별이 있으면(3,10,17,24,25,31) 총주문 금액에서 1,000원 할인
        // 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
        // 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용
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