package avl_trees;

public class Main {
    public static void main(String[] args) {
        var avl_tree = new AVLTree();

        avl_tree.insert(10);
        avl_tree.insert(5);
        avl_tree.insert(50);
        avl_tree.insert(20);
        avl_tree.insert(30);
        avl_tree.insert(40);
        avl_tree.insert(9);
        avl_tree.insert(4);
        avl_tree.insert(0);
        avl_tree.insert(1);
        avl_tree.insert(2);
        avl_tree.insert(1);
        avl_tree.insert(3);
        avl_tree.insert(4);
        avl_tree.insert(5);
        avl_tree.insert(10);

        avl_tree.print();
        // System.out.println("Done");
    }
}
