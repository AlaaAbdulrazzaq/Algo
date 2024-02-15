package F3.NB7;
import F3.NB5.NB5_interface;
import java.util.EmptyStackException;

public class NB7<E> implements NB5_interface<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> top;

    public NB7 ()
    {
        top = null;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        Node<E> current = top;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public E peek(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("Index " + n + " is not valid");
        }

        Node<E> current = top;
        for (int i = 0; i < n && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            return null; // Return null for an out-of-bounds index instead of throwing an exception
        }

        return current.data;
    }

    public E flush() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = null;

            // Pop elements until the stack is empty
            while (!empty()) {
                result = pop();
            }

            return result;
        }
    }




}
