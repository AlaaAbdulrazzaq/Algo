package NB26_2;

import NB26_1.StringCounter;

public class Main {
    public static void main(String[] args) {
        String[] str = {"man", "gråter", "när", "man", "tänker", "när"};
        minStringCounter strC = new minStringCounter(str);
        System.out.println(strC.getMostUsedString());
    }
}
