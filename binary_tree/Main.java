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

        thirdTree.insertNonBST(4);
        thirdTree.insertNonBST(3);
        thirdTree.insertNonBST(9);
        thirdTree.insertNonBST(0);
        thirdTree.insertNonBST(13);

        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(8);
        binaryTree.insert(6);
        binaryTree.insert(3);
        binaryTree.insert(10);
        binaryTree.insert(4);
        binaryTree.insert(0);
        binaryTree.insert(2);
        // binaryTree.print();

        thirdTree.print();

        System.out.println(BinaryTree.validateBST(thirdTree));
    }
}
