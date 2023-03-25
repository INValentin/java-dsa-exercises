package trie;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();

        trie.insert("apple");
        trie.insert("awesome");
        trie.insert("banana");
        trie.print();
    }
}
