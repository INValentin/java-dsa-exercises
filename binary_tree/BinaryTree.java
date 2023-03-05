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
            if (current.value == value) {
                var leftNode = current.leftChild;
                newNode.leftChild = leftNode;
                current.leftChild = newNode;
                return;
            } else if (current.value > value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    return;
                }

                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    return;
                }
                current = current.rightChild;
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
        printNode(root, false, 0);
        // LinkedList<Integer> q = new LinkedList<Integer>();
        // var current = root;
        // while (current.leftChild != null) {
        // var rightValue = current.rightChild != null ? current.rightChild.value :
        // Integer.MIN_VALUE;
        // q.add(current.value);
        // q.add(current.leftChild.value);
        // q.add(rightValue);
        // current = current.leftChild;
        // }
    }

}
