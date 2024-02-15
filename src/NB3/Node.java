package F2.NB3;

public class Node {
    public String data;
    public Node next;

    /**
     * Creates a Node with a null next field
     * @param str
     */
    public Node(String str) {
        data = str;
        next = null;
    }

    /**
     * Creates a node with a reference to the next node
     * @param str
     * @param nodeRef
     */
    public Node(String str, Node nodeRef) {
        data = str;
        next = nodeRef;
    }
}
