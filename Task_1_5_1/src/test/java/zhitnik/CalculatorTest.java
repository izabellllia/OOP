package zhitnik;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("calculationTestSource")
    void testCalculation(Double expected, String expression) {
        MyCalculator calculator = new MyCalculator();
        Double result = calculator.calc(expression);
        assertEquals(expected, result, 0.001);
    }

    private static Stream<Arguments> calculationTestSource() {
        return Stream.of(
                Arguments.of(3D, "+ 1 2"),
                Arguments.of(0D, "sin + - 1 2 1"),
                Arguments.of(3D, "+ cos 0 2"),
                Arguments.of(1024D, "pow 2 10"),
                Arguments.of(0D, "ln 1"),
                Arguments.of(15D, "* + 1 2 5")
        );
    }
}
