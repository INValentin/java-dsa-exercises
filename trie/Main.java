package trie;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();

        // trie.insert("apple");
        // trie.insert("awesome");
        // trie.insert("banana");
        trie.insert("cartoon");
        trie.insert("cart");

        System.out.println(trie.contains("cart"));
        System.out.println(trie.contains("cartoon"));
        trie.remove("cart");
        System.out.println(trie.contains("cart"));
        System.out.println(trie.contains("cartoon"));
    }
}
