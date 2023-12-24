package zhitnik;

import java.util.Stack;

public class SqrtOperation  implements BaseOperation<Double>{
    @Override
    public String getOperationRepresentation() {
        return "sqrt";
    }

    @Override
    public void calc(Stack<Double> stack) {
        stack.push(Math.sqrt(stack.pop()));
    }

    @Override
    public int getNumberOfArguments() {
        return 1;
    }
}