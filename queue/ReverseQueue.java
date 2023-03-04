package queue;

import java.util.Stack;

public class ReverseQueue {
    public static void reverse(ArrayQueue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
