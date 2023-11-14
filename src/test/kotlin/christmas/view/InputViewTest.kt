package christmas.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import christmas.controller.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest : NsTest() {
    @Test
    fun `음료만 시킨 경우`() {
        assertSimpleTest {
            runException("3", "제로콜라-4")
            assertThat(output()).contains("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `1 이상의 수량을 입력하지 않은 경우`() {
        assertSimpleTest {
            runException("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-0")
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `20 이상의 수량을 입력한 경우`() {
        assertSimpleTest {
            runException("3", "티본스테이크-10,바비큐립-10,초코케이크-2,제로콜라-5")
            assertThat(output()).contains("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.")
        }
    }

    override fun runMain() {
        main()
    }
}