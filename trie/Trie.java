package trie;

import java.util.ArrayList;
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

    public ArrayList<String> autoComplete(String prompt) {
        var results = new ArrayList<String>();
        autoComplete(root, 0, prompt, results);
        return results;
    }

    private void autoComplete(Node root, int index, String prompt, ArrayList<String> results) {
        if (index < prompt.length()) {
            var ch = prompt.charAt(index);
            if (root.hasChild(ch))
                autoComplete(root.getChild(ch), index + 1, prompt, results);
            return;
        }
        prompt += index != prompt.length() ? String.valueOf(root.value) : "";

        if (root.isEndOfWord)
            results.add(prompt);
        for (Node child : root.getChildren()) {
            autoComplete(child, index + 1, prompt, results);
        }
    }

}
