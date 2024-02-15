package NB7_1;

public class Main {
    public static void main(String[] args) {
        NB7_1 calculator = new NB7_1();

        try {
            // Valid expression
            String expression1 = "3 4 + 2 *";
            System.out.println(expression1 + " = " + calculator.eval(expression1));

            // Another valid expression
            String expression2 = "10 2 /";
            System.out.println(expression2 + " = " + calculator.eval(expression2));

            //String expression4 = "3 4 1 +";
            //System.out.println(expression4 + " = " + calculator.eval(expression4));

            // Expression with syntax error (invalid character)
            String expression3 = "3 4 $";
            System.out.println(expression3 + " = " + calculator.eval(expression3));
        } catch (NB7_1.SyntaxErrorException e) {
            System.err.println("Caught SyntaxErrorException: " + e.getMessage());
        }
    }
}
