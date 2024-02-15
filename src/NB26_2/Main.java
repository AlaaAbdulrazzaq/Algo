package NB26_2;


public class Main {
    public static void main(String[] args) {
        String[] str = {"man", "gråter", "när", "man", "tänker", "när"};
        minStringCounter strC = new minStringCounter(str);
        System.out.println(strC.getMostUsedString());
    }
}
