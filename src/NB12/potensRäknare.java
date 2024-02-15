package NB12;

public class potensRäknare {
    public static int findPotIterative(int pot, int number) {
        int result = 1;
        for (int i = 0; i < pot; i++) {
            result *= number;
        }
        return result;
    }
    public static int findPotRecursive(int pot, int number) {
        return findPotRecursive(pot, number, 1);
    }
    private static int findPotRecursive(int pot, int number, int resultSoFar) {
        if (pot == 0) {
            return resultSoFar;
        }
        resultSoFar *= number;
        pot -=1;
        return findPotRecursive(pot, number, resultSoFar);
    }
}