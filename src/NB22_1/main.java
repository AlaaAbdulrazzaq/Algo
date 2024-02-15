package NB22_1;


public class main {
    public static void main(String[] args) {
        BinarySearchTree<String> BST = new BinarySearchTree<>();
        BST.add("H");
        BST.add("B");
        BST.add("N");
        BST.add("A");
        BST.add("E");
        BST.add("C");
        BST.add("F");
        BST.add("D");
        System.out.println(BST.printTree());
    }
}
