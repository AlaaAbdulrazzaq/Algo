package NB26_3;

public class Main {
    public static void main(String[] args) {
        OpenAddressingHashTable<Integer, Integer> HT = new OpenAddressingHashTable<>(4);
        for (int i = 0; i < 6; i++) {
            HT.put(i, i);
            System.out.println(HT.toString());
        }
        HT.remove(2);
        System.out.println(HT.toString());

        System.out.println(HT.get(4));

        System.out.println(HT.get(20));
    }
}
