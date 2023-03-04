package queue;

import java.util.ArrayList;
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack0 = new Stack<Integer>();
    private Stack<Integer> stack1 = new Stack<Integer>();

    public void add(int num) {
        stack0.add(num);
    }

    public int remove() {
        while (!stack0.empty())
            stack1.add(stack0.pop());
        return stack1.pop();
    }

    public int peek() {
        while (!stack0.empty())
            stack1.add(stack0.pop());
        return stack1.peek();
    }

    public String toString() {
        var arr = new ArrayList<Integer>();
        Object[] arr2 = stack0.toArray();

        for (int i = (arr2.length - 1); i >= 0; i--) {
            arr.add((int) arr2[i]);
        }

        for (Integer integer : stack1) {
            arr.add(integer); 
        }

        return arr.toString();
    }

}
