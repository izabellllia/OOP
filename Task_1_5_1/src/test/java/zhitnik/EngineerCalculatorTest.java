package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineerCalculatorTest {

    @Test
    public void testEvaluateExpression() throws Exception {
        Assertions.assertEquals(0, EngineerCalculator.evaluateExpression("sin + - 1 2 1"), 1e-6);
    }
}
