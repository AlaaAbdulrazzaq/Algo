package NB23_1;

public class BinarySearchTree<E extends Comparable<E>>{
    private static class Node<E>{
        private E data;
        private Node<E> left,right;

        public Node(E data) {
            this.data = data;
            left=right=null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }
        else
        {
            return add(data,root);
        }
    }

    public boolean add(E data, Node<E> node){
        if(data.compareTo(node.data)==0){
            return false;
        }
        else if(data.compareTo(node.data)<0){
            if(node.left==null){
                node.left=new Node<>(data);
                return true;
            }
            else
            {
                return add(data,node.left);
            }
        }
        else
        {
            if(node.right==null){
                node.right=new Node<>(data);
                return true;
            }
            else
            {
                return add(data,node.right);
            }

        }
    }

    private E find(E target,Node<E> node){
        if(node==null){
            return null;
        }
        if(target.equals(node.data)){
            return node.data;
        }
        else if(target.compareTo(node.data)<0){
            return find(target,node.left);
        }
        return find(target,node.right);


    }

    private E find(E target,Node<E> node,int test){
        while(true){
            if(node==null){
                return null;
            }
            if(target.compareTo(node.data)==0){
                return node.data;
            } else if (target.compareTo(node.data)<0) {
                node=node.left;
            }
            else
            {
                node=node.right;
            }
        }
    }

    public E find(E target){
        //return find(target,root);
        return find(target,root,0);
    }

    public E maxRec(){
        return maxRec(root);
    }

    private E maxRec(Node<E> node){
        if(node==null){
            return null;
        }
        if(node.right==null){
            return node.data;
        }
        return maxRec(node.right);
    }

    public E maxLt(Node<E> node){
        if(node==null){
            return null;
        }
        else
        {
            while(true){
                if(node.right==null){
                    break;
                }
                node=node.right;
            }
        }
        return node.data;
    }
    public E maxLt(){
        return maxLt(root);
    }

    public E delete(E target){
        root = delete(target,root);
        return deletedData;
    }

    private E deletedData;

    private Node<E> delete(E target,Node<E> node){
        if(node==null){
            deletedData=null;
            return null;
        }
        if(target.compareTo(node.data)<0)
        {
            node.left=delete(target,node.left);
            return node;
        }
        else if (target.compareTo(node.data)>0)
        {
            node.right=delete(target,node.right);
            return node;
        }
        else
        {
            if(node.left==null){
                return node.right;
            }
            if(node.right==null){
                return node.left;
            }
            Node<E> nodeToMove=node.right, parentNodeToMove=node;
            if(nodeToMove.left==null){
                nodeToMove.left=node.left;
                return nodeToMove;
            }
            while(nodeToMove.left!=null){
                parentNodeToMove=nodeToMove;
                nodeToMove=nodeToMove.left;
            }
            parentNodeToMove.left = nodeToMove.right;
            node.data=nodeToMove.data;
            return node;
        }}




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if(node!=null){
            inOrder(node.left,sb);
            sb.append(":"+node.toString());
            inOrder(node.right,sb);
        }
    }
}
