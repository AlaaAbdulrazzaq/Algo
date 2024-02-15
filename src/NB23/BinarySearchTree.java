package NB23;

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

    public boolean add(E data){
        if (root == null){
            root = new Node<>(data);
            return true;
        }
        else {
            return add(data, root);
        }
    }

    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0){
            return false;
        }
        else if(data.compareTo(node.data)<0){
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }else {
                return add(data,node.left);
            }
        }
        else {
            if(node.right==null){
                node.right = new Node<>(data);
                return true;
            }else {
                return add(data,node.right);
            }
        }
    }

    public E find(E target){
        return find(target, root);
    }

    private E find(E target, Node<E> node){
        if (node == null){
            return null;
        }
        else if (target.compareTo(node.data) == 0){
            return node.data;
        }
        else if (target.compareTo(node.data) < 0){
            return find(target, node.left);
        }
        else {
            return find(target, node.right);
        }
    }

    public E delete(E target){
        root = delete(target,root);
        return deletedData;
    }

    private Node<E> delete(E target,Node<E> node){
        if (node == null){
            deletedData = null;
            return null;
        }
        else {
            if (target.compareTo(node.data) < 0){
                node.left = delete(target, node.left);
                return node;
            }
            else if (target.compareTo(node.data) > 0){
                node.right = delete(target, node.right);
                return node;
            }
            else {
                deletedData = node.data;
                if (node.left == null){
                    return node.right;
                }
                else if (node.right == null){
                    return node.left;
                }
                else {
                    Node<E> nodeToMove=node.right, parentNodeToMove=node;
                    if (nodeToMove.left == null){
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }
                    while (nodeToMove.left != null){
                        parentNodeToMove = nodeToMove;
                        node = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }

    public int nrOfLeaves(){
        if (root == null){
            return 0;
        }
        else {
            return nrOfLeaves(root);
        }
    }

    private int nrOfLeaves(Node<E> node){
        if (node.left == null && node.right == null){
            return 1;
        }
        int leaves = 0;
        if (node.left != null){
            leaves = nrOfLeaves(node.left);
        }
        if (node.right != null){
            leaves += nrOfLeaves(node.right);
        }

        return leaves;
    }

    public int nrOfNodes(){
        if (root == null){
            return 0;
        }
        else {
            return nrOfNodes(root);
        }
    }

    private int nrOfNodes(Node<E> node) {
        if (node == null) {
            return 0;
        }

        // Räkna antalet noder i vänster subträd
        int leftNodes = nrOfNodes(node.left);

        // Räkna antalet noder i höger subträd
        int rightNodes = nrOfNodes(node.right);

        // Inkludera rotnoden och returnera det totala antalet noder
        return 1 + leftNodes + rightNodes;
    }

    public int height(){
        if (root == null){
            return 0;
        }
        else {
            return height(root);
        }
    }

    private int height(Node<E> node){
        if (node == null){
            return 0;
        }

        int leftNode = 1 + height(node.left);

        int rightNode = 1 + height(node.right);

        return Math.max(leftNode, rightNode);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    private void inOrder(Node<E> node, StringBuilder sb){
        if (node != null){
            inOrder(node.left, sb);
            sb.append(": ").append(node);
            inOrder(node.right, sb);
        }
    }

}

