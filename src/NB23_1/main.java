package NB23_1;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BinarySearchTree<Integer> list = new BinarySearchTree<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(2);
        System.out.println(list.find(8));
        System.out.println(list.find(2));
        System.out.println("////");
        System.out.println(list.maxLt());
        System.out.println(list.maxRec());
    }
}
