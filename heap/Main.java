package heap;

import binary_tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        var myHeap = new Heap();
        int[] elements = { 5, 3, 8, 4, 1, 2 };
        for (int el : elements) {
            myHeap.insert(el);
        }
        System.out.println(Heap.kthLargest(elements, 3));
        // var result = Heapify.heapify(elements);
        // System.out.println(Arrays.toString(result));
        // printTree(result);
    }

    public static void printTree(int elements[]) {
        var binTree = new BinaryTree();
        for (int el : elements) {
            binTree.insert(el);
        }
        binTree.print();
    }
}
