package edu.realemj.exercises16;

public class BinTree <T extends Comparable<T>> {
    private BinNode<T> root;

    public void insert(T data) {
        BinNode<T> node = new BinNode<>(data);
        if(root == null) {
            root = node;
        }
        else {
            insertDown(node, root);
        }
    }

    private void insertDown(BinNode<T> node,
                            BinNode<T> current) {
        // current is NEVER null
        if(node.compareTo(current) < 0) {
            // Less than current
            if(current.getLeft() == null) {
                current.setLeft(node);
            }
            else {
                insertDown(node, current.getLeft());
            }
        }
        else {
            // Greater than or equal to current
            if(current.getRight() == null) {
                current.setRight(node);
            }
            else {
                insertDown(node, current.getRight());
            }
        }
    }

    public String toString() {
        if(root == null) {
            return "Empty";
        }

        GenericQueue<BinNode<T>> q = new GenericQueue<>();
        q.enqueue(root);
        String output = "";
        while(!q.isEmpty()) {
            BinNode<T> node = q.dequeue();
            output += node + ",";
            if(node.getLeft() != null) {
                q.enqueue(node.getLeft());
            }
            if(node.getRight() != null) {
                q.enqueue(node.getRight());
            }
        }
        return output;
    }

    public static void main(String [] args) {
        BinTree<Integer> tree = new BinTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        System.out.println(tree);
    }
}
