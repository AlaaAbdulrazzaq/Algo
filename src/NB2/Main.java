package NB2;

public class Main {
    public static void main(String[] args) {
        NB2.Array a1 = new NB2.Array(3);
        a1.add(7);
        a1.add(15);
        a1.add(0, 0);
        a1.add(1);
        System.out.println(a1.toString());
        a1.remove(2);
        System.out.println(a1.toString());
        System.out.println(a1.get(1));
        System.out.println(a1.indexOf(1));
        System.out.println(a1.indexOf(7));
        System.out.println(a1.indexOf(0));
        a1.set(0, 10);
        System.out.println(a1.toString());
    }
}
