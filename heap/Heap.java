package heap;

import java.util.Arrays;

public class Heap {
    private int count = 0;
    private int[] elements = new int[10];

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

    private int childValue(int index) {
        return (index + 1 > count) ? Integer.MIN_VALUE : elements[index];
    }

    private int getParent(int index) {
        return elements[parentIndex(index)];
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void swap(int childIndex, int parentIndex) {
        var temp = elements[childIndex];
        elements[childIndex] = elements[parentIndex];
        elements[parentIndex] = temp;
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
        var index = 0;
        var val = elements[index];

        while (true) {
            if (val < childValue(leftChildIndex(index))) {
                swap(leftChildIndex(index), index);
                index = leftChildIndex(index);
            } else if (val < childValue(rightChildIndex(index))) {
                swap(rightChildIndex(index), index);
                index = rightChildIndex(index);
            } else {
                break;
            }
            val = elements[index];
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
