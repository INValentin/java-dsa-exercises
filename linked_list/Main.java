package linked_list;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        var names = new LinkedList<String>();
        names.addFirst("Valentin");
        names.addLast("ISHIMWE");
        names.addLast("Home");
        names.addLast("School");
        names.addFirst("Buddy");
        names.print();
        // names.reverse();
        names.addLast("Church");
        names.addFirst("Computer");
        names.print();
        System.out.println(names.getKthItemFromEnd(3));
    }
}




