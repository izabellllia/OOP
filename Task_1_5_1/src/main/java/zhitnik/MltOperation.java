package zhitnik;

import java.util.Stack;
/**mlt.*/
public class MltOperation implements BaseOperation<Double>{
    @Override
    public String getOperationRepresentation() {
        return "*";
    }

    @Override
    public void calc(Stack<Double> stack) {
        stack.push(stack.pop() * stack.pop());
    }

    @Override
    public int getNumberOfArguments() {
        return 2;
    }
}