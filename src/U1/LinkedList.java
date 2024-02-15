package U1;

public class LinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;
    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            Node<E> newNode = new Node<>(item);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public void add(E item) {
        Node<E> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E get(int index) {
        if(index < 0 || index >size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        } else if (index == size) {
            return tail.data;
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public void remove(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        if(index == 0) {
            removeFirst();
        }
        else if(index == size-1){
            Node<E> node = getNode(index-1);
            node.next = null;
            tail = node;
        }else {
            Node<E> node = getNode(index-1);
            removeAfter(node);
        }

    }
    private Node<E> getNode(int index) {
        Node<E> currentNode = head;
        for (int i = 0; i < index && currentNode!= null; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    private void addFirst(E item) {
        head = new Node<>(item, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }


    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    private E removeAfter(Node<E> node) {
        Node<E> tmp = node.next;
        if(tmp != null) {
            node.next = tmp.next;
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

    public String toString() {
        String info = "";
        Node<E> current = head;
        while (current != null) {
            info += current.toString();
            current = current.next;
        }
        return info;
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
        private Node next;

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

        public String toString() {
            return "[" + data + "]";
        }
    }
}

