package F3.NB4;

import F3.NB4.NB4;

public class Main {
    public static void main(String[] args) {
        String expression1 = "(1+2)[()]({2*5} / [2, 3, 5])";

        System.out.println("first expression : " + NB4.isBalanced(expression1));

        String expression2 = "(1+2)[()]({2*5} / [2, 3, 5))";
        System.out.println("Second expression : " + NB4.isBalanced(expression2));
    }
}
