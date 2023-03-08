package avl_trees;

public class AVLTree {

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        if (root == null) {
            root = new AVLNode(value);
            return;
        }

        insertNode(root, value);
    }

    private void insertNode(AVLNode node, int value) {
        if (node.value > value) {
            if (node.leftChild == null) {
                node.leftChild = new AVLNode(value);
                return;
            }
            insertNode(node.leftChild, value);
            return;
        }

        if (node.rightChild == null) {
            node.rightChild = new AVLNode(value);
            return;
        }
        insertNode(node.rightChild, value);
    }

    private void printNode(AVLNode node, boolean isLeft, int depth) {
        if (node == null)
            return;
        printNode(node.rightChild, false, depth + 1);
        System.out.print("|-".repeat(depth));
        System.out.print(node.value);
        System.out.println();
        printNode(node.leftChild, true, depth + 1);

    }

    public void print() {
        System.out.println();
        printNode(root, false, 0);
        System.out.println();
    }
}
