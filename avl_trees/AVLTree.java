package avl_trees;

public class AVLTree {

    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private AVLNode insertNode(AVLNode node, int value) {
        if (node == null) {
            node = new AVLNode(value);
            node.height = 0;
            return node;
        }

        if (node.value > value)
            node.leftChild = insertNode(node.leftChild, value);
        else
            node.rightChild = insertNode(node.rightChild, value);

        setHeight(node);
        return balance(node);
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (getBalanceFactor(node.leftChild) < 0)
                node.leftChild = leftRotate(node.leftChild);
            return rightRotate(node);
        }
        if (isRightHeavy(node)) {
            if (getBalanceFactor(node.rightChild) > 0)
                node.rightChild = rightRotate(node.rightChild);
            return leftRotate(node);
        }

        return node;
    }

    private AVLNode leftRotate(AVLNode node) {
        var newRoot = node.rightChild;

        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(nodeHeight(node.leftChild), nodeHeight(node.rightChild)) + 1;
    }

    private AVLNode rightRotate(AVLNode node) {
        var newRoot = node.leftChild;

        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;

        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private void printNode(AVLNode node, boolean isLeft, int depth) {
        if (node == null)
            return;
        printNode(node.rightChild, false, depth + 1);
        System.out.print(" - ".repeat(depth));
        System.out.print("|" + nodeHeight(node) + "| ");
        System.out.print(node.value);
        System.out.println();
        printNode(node.leftChild, true, depth + 1);

    }

    private boolean isLeftHeavy(AVLNode node) {
        return getBalanceFactor(root) > 1;
    }

    public boolean isRightHeavy(AVLNode node) {
        return getBalanceFactor(node) < -1;
    }

    private int getBalanceFactor(AVLNode node) {
        return node == null ? 0 : nodeHeight(node.leftChild) - nodeHeight(node.rightChild);
    }

    private int nodeHeight(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    public void print() {
        System.out.println();
        printNode(root, false, 0);
        System.out.println();
    }
}
