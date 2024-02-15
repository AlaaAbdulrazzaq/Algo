package tree;


import java.util.TreeMap;

public class BinarySearchTree<E extends Comparable<E>> {
    private static class Node<E> {
        private E data;
        private Node<E> left, right;
        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    private E deletedData;
    public BinarySearchTree() {
        root = null;
        deletedData = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": " + node.toString());
            inOrder(node.right, sb);
        }
    }

    public boolean add(E data) {
        if(root == null) {
            root = new Node<>(data);
            return true;
        } else
            return add(data, root);
    }
    private boolean add(E data, Node<E> node) {
        if(data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if(node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else {
            if(node.right == null) {
                node.right = new Node<>(data);
                return true;
            } else {
                return add(data, node.right);
            }
        }
    }

    private E find(E target, Node<E> node) {
        if(node == null) {
            return null;
        }
        if(target.compareTo(node.data) == 0) {
            return node.data;
        }
        else if (target.compareTo(node.data) < 0) {
            return find(target, node.left);
        }else
            return find(target, node.right);
    }
    public E find(E target) {
        return find(target, root);
    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }
    private Node<E> delete(E target, Node<E> node) {
        if(node == null) {
            deletedData = null;
            return null;
        } else{
            if(target.compareTo(node.data) < 0) {
               node.left = delete(target, node.left);
               return node;
            } else if (target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            } else {
                deletedData = node.data;
                if(node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    Node<E> nodeToMove = node.right;
                    Node<E> parentNodeToMove = node;
                    if(nodeToMove.left == null) {
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }
                    while(nodeToMove.left!=null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
}
