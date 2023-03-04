package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayStack
 */
public class ArrayStack<E> {
    private List<E> stack;

    ArrayStack(int size) {
        stack = new ArrayList<>(size);
    }

    public void push(E element) {
        stack.add(element);
    }

    public E pop() {
        E el = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return el;
    }

    public E peek() {
        return stack.get(stack.size() - 1);
    }

    public boolean empty() {
        return stack.size() == 0;
    }
}