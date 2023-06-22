package com.devcourse.java.calculator.util;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculateUtilTest {

    @Test
    @DisplayName("식 계산 결과 확인")
    void calculateAndReturnEquationWithAnswer_Test() {
        //given
        String equation1 = "5 + 10";
        String equation2 = "10 + 2 * 50 + 30";
        String equation3 = "1 + 2 + 3 + 4 + 5";
        String equation4 = "6 + 10 / 2 + 4";
        String equation5 = "5 * 10 / 2 + 10";

        //when
        String equationWithAnswer = CalculateUtil.calculateAndReturnEquationWithAnswer(equation1);
        String equationWithAnswer2 = CalculateUtil.calculateAndReturnEquationWithAnswer(equation2);
        String equationWithAnswer3 = CalculateUtil.calculateAndReturnEquationWithAnswer(equation3);
        String equationWithAnswer4 = CalculateUtil.calculateAndReturnEquationWithAnswer(equation4);
        String equationWithAnswer5 = CalculateUtil.calculateAndReturnEquationWithAnswer(equation5);


        //then
        assertThat(equationWithAnswer).isEqualTo("5 + 10 = 15.0");
        assertThat(equationWithAnswer2).isEqualTo("10 + 2 * 50 + 30 = 140.0");
        assertThat(equationWithAnswer3).isEqualTo("1 + 2 + 3 + 4 + 5 = 15.0");
        assertThat(equationWithAnswer4).isEqualTo("6 + 10 / 2 + 4 = 15.0");
        assertThat(equationWithAnswer5).isEqualTo("5 * 10 / 2 + 10 = 35.0");

    }

    @Test
    @DisplayName("0으로 나눌 때 ArithmeticException 확인")
    void calculateAndReturnEquationWithAnswer_Divide_By_Zero_EXCEPTION_Test() {
        //given
        String equation1 = "2 + 5 / 0 * 3";
        String equation2 = "5 / 0";

        //when, then
        assertThatThrownBy(() -> CalculateUtil.calculateAndReturnEquationWithAnswer(equation1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining(ExceptionMessageConstant.DIVIDE_BY_ZERO_EXCEPTION);

        assertThatThrownBy(() -> CalculateUtil.calculateAndReturnEquationWithAnswer(equation2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining(ExceptionMessageConstant.DIVIDE_BY_ZERO_EXCEPTION);

    }
}