package trie;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();

        // trie.insert("apple");
        // trie.insert("awesome");
        trie.insert("banana");
        trie.insert("cartoon");
        trie.insert("card");
        trie.insert("canada");
        trie.insert("covert");
        trie.insert("cart");

        // System.out.println(trie.contains("cart"));
        // System.out.println(trie.contains("cartoon"));
        // System.out.println(trie.contains("cart"));
        // System.out.println(trie.contains("cartoon"));
        
        for (String string : trie.autoComplete("c")) {
            if (string != null)
                System.out.println(string);
        }
    }
}
