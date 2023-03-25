package heap;

import java.util.Arrays;

public class Heap {
    private int count = 0;
    private int[] elements = new int[20];

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == elements.length;
    }

    private int leftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;

    }

    public static int kthLargest(int[] arr, int k) {
        var heap = new Heap();
        for (int el : arr) {
            heap.insert(el);
        }

        for (int i = 1; i < k; i++) {
            heap.remove();
        }
        return heap.remove();
    }

    private int childValue(int index) {
        return (index + 1 > count) ? Integer.MIN_VALUE : elements[index];
    }

    private int getParent(int index) {
        return elements[parentIndex(index)];
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void swap(int firstIndex, int secondIndex) {
        var temp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = temp;
    }

    private void bubbleup() {
        var childIndex = count - 1;
        int lastValue = elements[childIndex];

        while (lastValue > getParent(childIndex)) {
            swap(childIndex, parentIndex(childIndex));
            childIndex = parentIndex(childIndex);
        }
    }

    public void insert(int val) {
        if (isFull())
            throw new IllegalStateException("Heap is full!");
        if (isEmpty()) {
            elements[count++] = val;
            return;
        }

        elements[count++] = val;
        bubbleup();
    }

    private void bubbleDown() {
        var currentIndex = 0;
        var largestIndex = 0;

        while (true) {
            var leftIndex = leftChildIndex(currentIndex);
            var rightIndex = rightChildIndex(currentIndex);
            largestIndex = currentIndex;
            if (elements[largestIndex] < elements[leftIndex]) {
                largestIndex = leftIndex;
            }
            if (elements[largestIndex] < elements[rightIndex]) {
                largestIndex = rightIndex;
            }

            if (currentIndex == largestIndex) {
                break;
            }

            swap(currentIndex, largestIndex);
            currentIndex = largestIndex;
        }
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty!");
        var root = elements[0];
        elements[0] = elements[count - 1];
        elements[count - 1] = 0;
        count--;
        bubbleDown();
        return root;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
