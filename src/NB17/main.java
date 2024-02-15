package NB17;

public class main {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            l.add("E" + i);
        }
        System.out.println(l.toString());
        System.out.println(l.getNode(0));
    }
}