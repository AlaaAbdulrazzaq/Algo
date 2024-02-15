package NB23;

public class main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        for (int i = 0; i < 5; i++) {
            t.add(i);
        }
        System.out.println("nrOfNodes: "+ t.nrOfNodes());
        System.out.println("nr Of Leaves " + t.nrOfLeaves());
        System.out.println("Height "+ t.height());
    }
}
