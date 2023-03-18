package heap;

public class Heapify {
    public static int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public static int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    public static int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private static void swap(int firstIndex, int secondIndex, int[] arr) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void bubbleUp(int index, int[] arr) {
        var parentIndex = getParentIndex(index);
        while (parentIndex > -1 && (arr[index] > arr[parentIndex])) {
            swap(index, parentIndex, arr);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    private static void heapify(int index, int[] arr) {
        var leftIndex = getLeftChildIndex(index);
        var rightIndex = getRightChildIndex(index);
        if (leftIndex > arr.length - 1)
            return;
        if (arr[index] < arr[leftIndex]) {
            swap(leftIndex, index, arr);
            bubbleUp(index, arr);
        }

        if (rightIndex > arr.length - 1)
            return;
        if (arr[index] < arr[rightIndex]) {
            swap(rightIndex, index, arr);
            bubbleUp(index, arr);
        }
        heapify(rightIndex, arr);
        heapify(leftIndex, arr);
    }

    public static int[] heapify(int[] arr) {
        heapify(0, arr);
        return arr;
    }
}