package NB15;

public class main {
    public static void main(String[] args) {
        //output should be 11
        System.out.println(BinaryTranslator.BinaryTranslatorStrInt("1011"));

        //output should be 3
        System.out.println(BinaryTranslator.BinaryTranslatorStrInt("11"));

        //output is "" "1" "0" "1" "1"
        System.out.println(BinaryTranslator.BinaryTranslatorIntStr(11));
    }
}
