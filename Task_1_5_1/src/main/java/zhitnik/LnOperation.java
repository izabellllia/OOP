package zhitnik;

import java.util.Stack;
/**ln.*/

public class LnOperation implements BaseOperation<Double>{
    @Override
    public String getOperationRepresentation() {
        return "ln";
    }

    @Override
    public void calc(Stack<Double> stack) {
        stack.push(Math.log(stack.pop()));
    }

    @Override
    public int getNumberOfArguments() {
        return 1;
    }
}