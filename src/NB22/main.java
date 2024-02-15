package NB22;

public class main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<>();
        BST.add(4);
        BST.add(2);
        BST.add(6);
        BST.add(1);
        BST.add(3);
        BST.add(5);
        BST.add(7);
        System.out.println(BST.toString());
    }
}
