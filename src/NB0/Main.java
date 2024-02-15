package NB0;

public class Main {
    public static void main(String[] args) {
        NBo<Integer> list = new NBo<>();
        list.add(2);
        list.add(4);
        System.out.println(list.toString());
        list.add(1, 10);
        System.out.println(list.toString());
        System.out.println(list.get(2));
        list.set(0, 8);
        System.out.println(list.indexOf(4));
        System.out.println(list.toString());
        list.add(2, 2);
        list.add(2, 8);
        list.add(0, 0);
        list.remove(0);
        System.out.println(list.toString());
    }
}
