package trie;

public class Trie {
    private class Node {
        char value;
        Node[] children = new Node[26];
        boolean isEndOfWord = false;

        Node() {
        }

        Node(char value) {
            this.value = value;
        }
    }

    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        var current = root;
        int index = 0;
        for (char character : word.toCharArray()) {
            index = character - 'a';
            if (current.children[index] == null) {
                Node newNode = new Node(character);
                current.children[index] = newNode;
            }
            current = current.children[index];
        }
        if (current != null)
            current.isEndOfWord = true;
    }

    private void printNode(Node node, boolean isLeft, int depth) {
        if (node == null)
            return;
        System.out.print("|-".repeat(depth));
        for (int i = 0; i < 26; i++) {
            printNode(node.children[i], false, depth + 1);
        }
        System.out.println(node.value);
        System.out.println();

    }

    public void print() {
        System.out.println();
        printNode(root, false, 0);
        System.out.println();
    }
}
