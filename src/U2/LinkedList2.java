package Labb1.U2;

import Labb1.U1.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList2<E> {
    private int size;
    private Node<E> head;

    public LinkedList2() {
        size = 0;
        head = null;
    }
    public Iterator<E> iterator(){
        return new Itr(head);
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public E get(int index) {
        if(index < 0 || index >size) {
            throw new IndexOutOfBoundsException("Out of bounds");
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
        else {
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

    private class Itr implements Iterator<E> {
        Node<E> current;
        Node<E> previous;
        Node<E> previousPrevious;

        public Itr(Node<E> start) {
            current = start;
            previous = null;
            previousPrevious = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            if (previous != null) {
                previousPrevious = previous;
            }
            previous = current;
            current = current.next;
            return previous.data;
        }

        @Override
        public void remove() {
            if (previous == null) {
                throw new IllegalStateException("Next method has not yet been called, or the remove method has already been called after the last call to the next method");
            }

            if (previousPrevious == null) {
                // Removing the first element
                head = current;
            } else {
                // Removing an element other than the first
                previousPrevious.next = current;
            }

            // Update the previous node to the previousPrevious node since the previous node is removed
            previous = previousPrevious;

            // Decrease the size of the list
            size--;
        }
    }

}

