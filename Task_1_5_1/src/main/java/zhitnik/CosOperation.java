package zhitnik;

import java.util.Stack;
/**cos.*/
public class CosOperation implements BaseOperation<Double> {
    @Override
    public String getOperationRepresentation() {
        return "cos";
    }

    @Override
    public void calc(Stack<Double> stack) {
        stack.push(Math.cos(stack.pop()));
    }

    @Override
    public int getNumberOfArguments() {
        return 1;
    }
}