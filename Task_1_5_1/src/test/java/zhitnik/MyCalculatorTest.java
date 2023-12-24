package zhitnik;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test class for calculator
 */
@DisplayName("Test for calculator")
public class MyCalculatorTest {

    /**
     * Test for normal calculations
     * @param ans The expected result
     * @param formula The mathematical formula to calculate
     */
    @ParameterizedTest
    @MethodSource("calculationTestSource")
    @DisplayName("Normal calculations test")
    public void calculationTest(Double ans, String formula) {
        MyCalculator calculator = new MyCalculator();
        assertEquals(ans, calculator.calc(formula), 0.000001);
    }

    /**
     * Test for exceptions
     * @param formula The mathematical formula to calculate
     * @param exceptionClass The expected type of exception
     * @param exceptionMessage The expected exception message
     */
    @ParameterizedTest
    @MethodSource("exceptionsTestSource")
    @DisplayName("Exceptions test")
    public void exceptionTest(String formula, Class<? extends Throwable> exceptionClass, String exceptionMessage) {
        MyCalculator calculator = new MyCalculator();
        var a = Assertions.assertThrows(
                exceptionClass,
                () -> calculator.calc(formula)
        );
        assertEquals(exceptionMessage, a.getMessage());
    }

    /**
     * Provides test data for normal calculations
     * @return Stream of arguments for normal calculation testing
     */
    public static Stream<Arguments> calculationTestSource() {
        return Stream.of(
                Arguments.of(3D, "+ 1 2"),
                Arguments.of(0D, "sin + - 1 2 1"),
                Arguments.of(3D, "+ cos 0 2"),
                Arguments.of(1024D, "pow 2 10"),
                Arguments.of(0D, "ln 1"),
                Arguments.of(15D, "* + 1 2 5")
        );
    }

    /**
     * Provides test data for exceptions
     * @return Stream of arguments for exception testing
     */
    public static Stream<Arguments> exceptionsTestSource() {
        return Stream.of(
                Arguments.of("atan 12",
                        IllegalArgumentException.class,
                        "Cannot parse operation = 'atan' (Check that the operation is registered)"
                ),
                Arguments.of(
                        "sin 12 13 42",
                        IllegalArgumentException.class,
                        "Number of arguments are different to number of sum(operation.getNumberOfArguments"
                ),
                Arguments.of(
                        "pow 2",
                        IllegalArgumentException.class,
                        "Cannot calc formula due to number of input arguments"
                )
        );
    }
}
