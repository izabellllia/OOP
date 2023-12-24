package zhitnik;

import java.util.Stack;

/**
 * Interface for MyCalculator operations.
 * @param <T> Type of actions for Calculator
 */
public interface BaseOperation<T> {
    /**
     * @return String representation of operation
     */
    String getOperationRepresentation();

    /**
     * Calculates action by operator and put's result at the end of the stack.
     * @param stack Stack to pop\push values\results
     */
    void calc(Stack<T> stack);

    /**
     * @return Number of input values for operator
     */
    int getNumberOfArguments();
}