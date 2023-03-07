package binary_tree;

public class BinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

    }

    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(int rootValue) {
        this.root = new Node(rootValue);
    }

    private Node getNode(int value) {
        var current = root;

        while (current != null) {
            if (current.value == value)
                return current;
            else if (current.value > value)
                current = current.leftChild;
            else
                current = current.rightChild;
        }

        return current;
    }

    public boolean find(int value) {
        return getNode(value) != null;
    }

    public void insert(int value) {
        var current = root;
        var newNode = new Node(value);

        if (current == null) {
            root = newNode;
            return;
        }

        while (current != null) {
            if (current.value < value) {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    return;
                }
                current = current.rightChild;
            } else {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    return;
                }

                current = current.leftChild;
            }
        }

    }

    private void printNode(Node node, boolean isLeft, int depth) {
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

    public boolean treeEqual(BinaryTree tree) {
        return equals(root, tree.root);
    }

    private boolean equals(Node firstRoot, Node secondRoot) {
        if (firstRoot == null && secondRoot == null)
            return true;
        if (firstRoot == null || secondRoot == null)
            return false;

        var rootEquals = firstRoot.value == secondRoot.value;

        boolean leftEquals = rootEquals ? equals(firstRoot.leftChild, secondRoot.leftChild) : false;
        boolean rightEquals = leftEquals ? equals(firstRoot.rightChild, secondRoot.rightChild) : false;
        return (rootEquals && leftEquals && rightEquals);
    }

}
