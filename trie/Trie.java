package trie;

import java.util.HashMap;

public class Trie {
    private class Node {
        char value;
        private HashMap<Character, Node> children = new HashMap<>();
        boolean isEndOfWord = false;

        Node() {
        }

        Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char character) {
            return children.containsKey(character);
        }

        public void addChild(char character, Node node) {
            children.put(character, node);
        }

        public Node getChild(char character) {
            return children.get(character);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char key) {
            children.remove(key);
        }

        @Override
        public String toString() {
            return "value=" + this.value;
        }
    }

    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch, new Node(ch));
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void remove(String word) {
        remove(root, -1, word);
    }

    private boolean remove(Node node, int index, String word) {
        if (index == word.length() - 1) {
            node.isEndOfWord = false;
            return node.getChildren().length == 0;
        }
        var child = node.getChild(word.charAt(index + 1));
        var hasNoChildren = remove(child, index + 1, word);
        if (hasNoChildren) {
            node.removeChild(word.charAt(index + 1));
            return node.getChildren().length == 0 && !node.isEndOfWord;
        }
        return false;
    }

}
