package NB4;

import java.util.Stack;


public class NB4 {
    private static final String CLOSE = ")]}";
    private static final String OPEN = "([{";
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        int index = 0;
        while (balanced && index < expression.length()) {
            char nextChar = expression.charAt(index);

            if (isOpen(nextChar)) {
                stack.push(nextChar);
            } else if (isClosed(nextChar)) {
                if (stack.empty() || !(OPEN.indexOf(stack.peek()) == CLOSE.indexOf(nextChar))) {
                    balanced = false;
                } else {
                    stack.pop();
                }
            }

            index++;
        }
        return (balanced && stack.empty());
    }
    private static boolean isOpen(char ch) {
        return OPEN.indexOf(ch) > -1;
    }
    private static boolean isClosed(char ch) {
        return CLOSE.indexOf(ch) > -1;
    }
}
