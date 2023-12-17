package zhitnik;

import java.util.Scanner;
import java.util.Stack;

public class EngineerCalculator {
    public static double evaluateExpression(String input) throws Exception {
        String[] tokens = input.split("\\s+");
        Stack<Double> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                double result = compute(token, operand1, operand2);
                stack.push(result);
            } else if (isFunction(token)) {
                double operand = stack.pop();
                double result = computeFunction(token, operand);
                stack.push(result);
            } else {
                throw new Exception("Неизвестный токен: " + token);
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean isFunction(String token) {
        return token.equals("log") || token.equals("pow") || token.equals("sqrt") ||
                token.equals("sin") || token.equals("cos");
    }

    private static double compute(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }

    private static double computeFunction(String function, double operand) {
        switch (function) {
            case "log":
                if (operand <= 0) {
                    throw new IllegalArgumentException("Неверный аргумент для функции log");
                }
                return Math.log(operand);
            case "pow":
                return Math.pow(operand, 2);
            case "sqrt":
                if (operand < 0) {
                    throw new IllegalArgumentException("Неверный аргумент для функции sqrt");
                }
                return Math.sqrt(operand);
            case "sin":
                return Math.sin(operand);
            case "cos":
                return Math.cos(operand);
            default:
                throw new IllegalArgumentException("Неизвестная функция: " + function);
        }
    }
}
