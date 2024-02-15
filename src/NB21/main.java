package NB21;

public class main {
    public static void main(String[] args) {
        BinarySearchTree<String> BST = new BinarySearchTree<>();
        BST.add("Ost");
        BST.add("Ramos");
        BST.add("Pineapple");
        BST.add("Straw");
        BST.add("Money");
        BST.add("Nachos");
        BST.add("Liquid");
        System.out.println("Tree height: "+ BST.height());

        BinarySearchTree<String> BST2 = new BinarySearchTree<>();
        BST2.add("Liquid");
        BST2.add("Money");
        BST.add("Nachos");
        BST2.add("Ost");
        BST2.add("Pineapple");
        BST2.add("Ramos");
        BST2.add("Straw");
        System.out.println("Tree height: "+ BST2.height());
    }
}
