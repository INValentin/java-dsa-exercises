package heap;

public class Main {
    public static void main(String[] args) {
        var myHeap = new Heap();
        myHeap.insert(10);
        myHeap.insert(20);
        myHeap.insert(500);
        myHeap.insert(70);
        myHeap.insert(-10);
        myHeap.remove();

        System.out.println(myHeap);
        
    }
}
