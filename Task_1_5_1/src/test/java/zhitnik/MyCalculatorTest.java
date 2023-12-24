package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for calculator")
public class MyCalculatorTest {

    @ParameterizedTest
    @MethodSource("calculationTestSource")
    @DisplayName("Normal calculations test")
    public void calculationTest(Double ans, String formula) {
        MyCalculator calculator = new MyCalculator();
        assertEquals(ans, calculator.calc(formula), 0.000001);
    }

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

    @Test
    public void registerExceptionTest(){
        MyCalculator calculator = new MyCalculator();
        var a = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.registerOperation(new CosOperation())
        );
        Assertions.assertEquals("this key is exists in HashMap", a.getMessage());
    }

    @Test
    public void registerNoExceptionTest(){
        MyCalculator calculator = new MyCalculator();
        calculator.registerOperation(new CosOperation(), true);
    }

    @Test
    public void registerActionTest(){
        MyCalculator calculator = new MyCalculator(CalcModes.EMPTY_OPERATIONS);
        var a = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calc("cos 0")
        );
        Assertions.assertEquals(
                "Cannot parse operation = 'cos' (Check that the operation is registered)",
                a.getMessage()
        );

        calculator.registerOperation(new CosOperation());
        Assertions.assertDoesNotThrow(() -> calculator.calc("cos 0"));
    }
}