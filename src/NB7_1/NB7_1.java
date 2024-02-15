package F3.NB7_1;

import java.util.Stack;
import java.util.EmptyStackException;

public class NB7_1 {
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    public static int eval(String expression) throws SyntaxErrorException {
        operandStack = new Stack<>();
        String[] tokens = expression.split(" +");

        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    operandStack.push(evalOp(nextToken.charAt(0)));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }

            int answer = operandStack.pop();

            if (operandStack.empty()){
                return answer;
            }
            else {
                throw new SyntaxErrorException("Syntax Error");
            }
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    private static final String OPERATORS = "+-*/";
    private static Stack<Integer> operandStack;

    private static int evalOp(char op) {
        int result;
        int rhs = operandStack.pop(); // Här måste du plocka operand2 först
        int lhs = operandStack.pop(); // och sedan operand1

        switch (op) {
            case '+':
                result = lhs + rhs;
                break;
            case '-':
                result = lhs - rhs;
                break;
            case '*':
                result = lhs * rhs;
                break;
            case '/':
                result = lhs / rhs;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }

        return result;
    }

    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }


}
