package christmas.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import christmas.controller.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {
    @Test
    fun `이벤트 혜택 미리보기`() {
        assertSimpleTest {
            runException("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            assertThat(output()).contains(
                "<주문 메뉴>\n",
                "티본스테이크 1개\n",
                "바비큐립 1개\n",
                "초코케이크 2개\n",
                "제로콜라 1개\n"

            )
        }
    }

    @Test
    fun `혜택 내역 출력`() {
        assertSimpleTest {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            assertThat(output()).contains(
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원"
            )
        }
    }


    override fun runMain() {
        main()
    }
}