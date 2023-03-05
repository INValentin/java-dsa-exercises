package binary_tree;

public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Tree!");

        var binaryTree = new BinaryTree(5);

        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(8);
        binaryTree.insert(6);
        binaryTree.insert(3);
        binaryTree.insert(10);
        binaryTree.insert(4);
        binaryTree.insert(0);
        binaryTree.insert(2);
        binaryTree.print();
        System.out.println(binaryTree.find(6));
    }
}
