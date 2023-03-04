package queue;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> mylist = new LinkedList<>();

        mylist.addLast(1);
        mylist.addLast(2);
        mylist.addLast(3);

        var myQueue = new ArrayQueue<Integer>(10);

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        
        ReverseQueue.reverse(myQueue);
        
        // myQueue.print();

        // stack queue

        var sQueue = new StackQueue();

        sQueue.add(10);
        sQueue.add(20);
        sQueue.add(30);
        // sQueue.remove();

        System.out.println(sQueue);
        System.out.println(sQueue.peek());
    }
}
