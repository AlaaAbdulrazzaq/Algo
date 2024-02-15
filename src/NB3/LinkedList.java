package NB3;

public class LinkedList<E> {
    private int size;
    private Node<E> head;
    public LinkedList() {
        size = 0;
        head = null;
    }
    public void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    private E removeAfter(Node<E> node) {
        Node<E> tmp = node.next;
        if(tmp != null) {
            tmp.next = node.next;
            size--;
            return tmp.data;
        } else {
            return null;
        }
    }

    private E removeFirst() {
        Node<E> tmp = head;
        if(head != null) {
            head = head.next;
        }
        if(tmp != null) {
            size--;
            return tmp.data;
        } else {
            return null;
        }
    }


    /**A Node is the building block for single-linked list.*/
    private static class Node<E> {
        /**
         * the reference to the data
         */
        private E data;
        /**
         * the reference to the next node in line
         */
        private Node<E> next;

        /**
         * creates a new node with a null next field
         * @param dataItem the data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem
         * @param nodeRef
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }
}
