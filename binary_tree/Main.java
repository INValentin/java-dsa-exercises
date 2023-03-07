package binary_tree;

public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Tree!");

        var binaryTree = new BinaryTree(5);
        var secondTree = new BinaryTree();
        var thirdTree = new BinaryTree();

        secondTree.insert(4);
        secondTree.insert(3);
        secondTree.insert(9);
        secondTree.insert(13);
        secondTree.insert(0);
        secondTree.print();
        thirdTree.insert(4);
        thirdTree.insert(3);
        thirdTree.insert(9);
        thirdTree.insert(0);
        thirdTree.insert(13);
        thirdTree.print();

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
        System.out.println(secondTree.treeEqual(thirdTree));
    }
}
