package linked_list;

public class LinkedList<K> {

    private class Node<E> {
        private E value;
        private Node<E> next;

        Node(E val) {
            this.value = val;
        }

    }

    private Node<K> first;
    private Node<K> last;
    private int count;

    LinkedList() {
        count = 0;
    }

    public void addFirst(K value) {
        var newNode = new Node<>(value);
        newNode.next = first;
        first = newNode;
        count++;
    }

    public int size() {
        return count;
    }

    public void addLast(K value) {
        Node<K> newLastNode = new Node<K>(value);
        Node<K> node = first;
        while (node != null) {
            if (node.next == null) {
                node.next = newLastNode;
                last = newLastNode;
                newLastNode.next = null;
                count++;
                return;
            }
            node = node.next;
        }

    }

    public void deleteFirst() {
        if (count == 0)
            return;
        Node<K> second = first.next;
        first.next = null;
        first = second;
        count--;
    }

    public void deleteLast() {
        if (count == 0)
            return;
        Node<K> node = first;
        while (node != null) {
            // Before last node
            if (node.next != null && node.next.next == null) {
                node.next = null;
                last = node;
                count--;
                return;
            }
            node = node.next;
        }
        first = last = null;
        count--;
    }

    public boolean contains(K searchValue) {
        return indexOf(searchValue) != -1;
    }

    public int indexOf(K searchValue) {
        int index = 0;
        Node<K> node = first;
        while (node != null) {
            if (node.value == searchValue) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public void print() {
        Node<K> node = first;
        System.out.print("\n[");
        while (node != null) {
            String point = node.next == null ? "" : " -> ";
            System.out.print(node.value + point);
            node = node.next;
        }
        System.out.print("]\n");
    }

    public void reverse() {
        Node<K> nextHead = first;
        Node<K> head = null;

        while (nextHead != null) {
            var temp = nextHead.next;
            nextHead.next = head;
            head = nextHead;
            nextHead = temp;
        }

        last = first;
        first = head;
    }

    public K getKthItemFromEnd(int k) {
        if (k <= 0)
            throw new IllegalArgumentException(new Throwable("k parameter out of range"));
        var current = first;
        Node<K> kthFromCurrent = first;
        int i = 1;

        while (kthFromCurrent != last) {
            kthFromCurrent = kthFromCurrent.next;
            if (i >= k) {
                current = current.next;
            }
            i += 1;
        }

        if (k > i)
            throw new IllegalArgumentException(new Throwable("k parameter out of range"));

        return current.value;
        /**
         * [1 -> 2 -> 3 -> 4 -> 5]
         * kth(1) = 4, kth(3) = 2
         */
    }
}
