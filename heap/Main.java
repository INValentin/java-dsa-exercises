package heap;

import java.util.Arrays;
import binary_tree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        // var myHeap = new Heap();
        // myHeap.insert(10);
        // myHeap.insert(20);
        // myHeap.insert(500);
        // myHeap.insert(70);
        // myHeap.insert(-10);
        // myHeap.remove();

        // System.out.println(myHeap);
        int[] elements = { 5, 3, 8, 4, 1, 2 };
        var result = Heapify.heapify(elements);
        System.out.println(Arrays.toString(result));
        printTree(result);
    }

    public static void printTree(int elements[]) {
        var binTree = new BinaryTree();
        for (int el : elements) {
            binTree.insert(el);
        }
        binTree.print();
    }
}
