package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    public static Stream<Arguments> calculateTestSource() {
        return Stream.of(
                Arguments.of(3D, "+ 1 2"),
                Arguments.of(0D, "sin + - 1 2 1"),
                Arguments.of(3D, "+ cos 0 2"),
                Arguments.of(1024D, "pow 2 10"),
                Arguments.of(0D, "ln 1"),
                Arguments.of(15D, "* + 1 2 5")
        );
    }

    @ParameterizedTest
    @MethodSource("calculateTestSource")
    public void calculateTest(Double ans, String formula) {
        Assertions.assertEquals(
                ans,
                Main.calculate(formula)
        );
    }
}