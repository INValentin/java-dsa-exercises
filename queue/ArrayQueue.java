package queue;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<E> {
    private List<E> arr;

    ArrayQueue(int size) {
        arr = new ArrayList<>(size);
        System.out.println(arr.size());
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }

    public void add(E element) {
        arr.add(element);
    }

    public void print() {
        System.out.println("Size: " + arr.size());
        System.out.println(arr.toString());
    }

    public E remove() {
        if (isEmpty())
            throw new IllegalStateException();
        return arr.remove(0);
    }

    public E peek() {
        return arr.get(0);
    }
}
