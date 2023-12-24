package zhitnik;

import java.util.Stack;
/**pow.*/

public class PowOperation implements BaseOperation<Double>{
    @Override
    public String getOperationRepresentation() {
        return "pow";
    }

    @Override
    public void calc(Stack<Double> stack) {
        stack.push(Math.pow(stack.pop(), stack.pop()));
    }

    @Override
    public int getNumberOfArguments() {
        return 2;
    }
}