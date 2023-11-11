//package christmas.model
//
//class EventPlanner {
//
//    // 할인 금액 계산
//    private fun calculateDiscount(date: Int): Int {
//        val baseDiscount = 1000
//        val dailyIncrement = 100
//        val discountDays = (date - 1).coerceAtLeast(0) // 음수 방지
//        return baseDiscount + dailyIncrement * discountDays
//    }
//
//    // 할인 전 총주문 금액에 따라 증정 메뉴 선택
//    private fun selectGiftMenu(orders: Map<String, Int>, discountAmount: Int): String {
//        val totalAmount = calculateTotalAmount(orders)
//        return when {
//            totalAmount >= 120000 -> "Champagne"
//            isSpecialDiscountDay(date) -> "SpecialDiscount"
//            else -> "None"
//        }
//    }
//
//    // 이벤트 결과 문자열 생성
//    private fun generateEventResult(
//        orders: Map<String, Int>,
//        discountAmount: Int,
//        giftMenu: String
//    ): String {
//        val totalAmount = calculateTotalAmount(orders)
//        val discountedAmount = totalAmount - discountAmount
//        val badge = getEventBadge(discountedAmount)
//
//        return """
//            <주문 메뉴>
//            ${orders.map { "${it.key} ${it.value}개" }.joinToString("\\n")}
//
//            <할인 전 총주문 금액>
//            ${totalAmount}원
//
//            <증정 메뉴>
//            ${if (giftMenu == "None") "없음" else giftMenu}
//
//            <혜택 내역>
//            ${getDiscountHistory(discountAmount)}
//
//            <총혜택 금액>
//            ${discountAmount}원
//
//            <할인 후 예상 결제 금액>
//            ${discountedAmount}원
//
//            <12월 이벤트 배지>
//            $badge
//        """.trimIndent()
//    }
//
//    // 총주문 금액 계산
//    private fun calculateTotalAmount(orders: Map<String, Int>): Int {
//        // orders에 따라 주문 금액 계산
//        // ...
//        return totalAmount
//    }
//
//    // 특별 할인 날짜인지 확인
//    private fun isSpecialDiscountDay(date: Int): Boolean {
//        // 특별 할인 날짜인지 여부를 확인
//        // ...
//        return isSpecialDay
//    }
//
//    // 이벤트 배지 반환
//    private fun getEventBadge(discountedAmount: Int): String {
//        return when {
//            discountedAmount >= 20000 -> "산타"
//            discountedAmount >= 10000 -> "트리"
//            discountedAmount >= 5000 -> "별"
//            else -> "없음"
//        }
//    }
//
//    // 할인 내역 반환
//    private fun getDiscountHistory(discountAmount: Int): String {
//        val history = mutableListOf<String>()
//
//        // 크리스마스 디데이 할인
//        if (isChristmasDiscountDay()) {
//            history.add("크리스마스 디데이 할인: -$discountAmount원")
//        }
//
//        // 평일/주말 할인
//        val weekdayDiscount = calculateWeekdayDiscount(orders)
//        val weekendDiscount = calculateWeekendDiscount(orders)
//        if (weekdayDiscount > 0) {
//            history.add("평일 할인: -$weekdayDiscount원")
//        }
//        if (weekendDiscount > 0) {
//            history.add("주말 할인: -$weekendDiscount원")
//        }
//
//        // 특별 할인
//        if (isSpecialDiscountDay(date)) {
//            history.add("특별 할인: -1000원")
//        }
//
//        // 증정 이벤트
//        if (totalAmount >= 120000) {
//            history.add("증정 이벤트: -25000원")
//        }
//
//        return if (history.isEmpty()) "없음" else history.joinToString("\\n")
//    }
//
//    // 크리스마스 디데이 할인 날짜인지 확인
//    private fun isChristmasDiscountDay(): Boolean {
//        // 현재 날짜가 크리스마스 디데이인지 여부 확인
//        // ...
//        return isChristmasDay
//    }
//
//    // 평일 할인 계산
//    private fun calculateWeekdayDiscount(orders: Map<String, Int>): Int {
//        // 주중 할인 금액 계산
//        // ...
//        return weekdayDiscountAmount
//    }
//
//    // 주말 할인 계산
//    private fun calculateWeekendDiscount(orders: Map<String, Int>): Int {
//        // 주말 할인
//
//        //금액 계산
//                // ...
//                return weekendDiscountAmount
//    }
//}