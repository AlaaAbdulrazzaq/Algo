package NB26_1;

public class Main {
    public static void main(String[] args) {
        String[] str = {"man", "gråter", "när", "man", "tänker", "när"};
        StringCounter strC = new StringCounter(str);
        System.out.println(strC.getMostUsedString());
    }
}
