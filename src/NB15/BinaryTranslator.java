package NB15;

public class BinaryTranslator {

    public static int BinaryTranslatorStrInt(String binary) {
        return BinaryTranslatorStrInt(binary, 0,0, binary.length());
    }

    private static int BinaryTranslatorStrInt(String binary, int index, int number, int lengthOfString) {
        if(index == lengthOfString) {
            return number;
        }
        if(binary.charAt(index) == '1') {
            number += findPotRecursive((lengthOfString-1) - index, 2);

        }
        return BinaryTranslatorStrInt(binary, index+1, number, lengthOfString);
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


    public static String BinaryTranslatorIntStr(int number) {
        if (number == 0) {
            return "";
        } else {
            return BinaryTranslatorIntStr(number / 2) + (number % 2);
        }
    }
}
