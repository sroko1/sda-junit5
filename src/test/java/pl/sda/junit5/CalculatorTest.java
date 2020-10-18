package pl.sda.junit5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldReturnSumWhenAddTwoNumbers() {
        // given
        long a = 1;
        long b = 2;
        // when
        long result = calculator.add(a, b);
        // then
        assertEquals(3, result);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldReturnDifferenceWhenSubtractTwoNumbers() {
        // given
        long a = 1;
        long b = 2;
        // when
        long result = calculator.subtract(a, b);
        // then
        assertEquals(-1, result);
        assertThat(result).isEqualTo(-1);
    }

}
