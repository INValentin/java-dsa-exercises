package hash_tables;

public class Main {
    public static void main(String[] args) {
        // System.out.println(FirstNonRepeatingChar.firstNonRepeatedChar("Hash!"));
        // System.out.println(FirstRepeatingChar.firstRepeatedChar("Hassh!"));

        MyHashTable<String, Integer> ages = new MyHashTable<>();

        ages.put("valentin", 21);
        ages.put("Mike", 25);

        System.out.println(ages.contains("valentin"));
        
        System.out.println(ages.get("valentin"));
        ages.remove("valentin");
        System.out.println(ages.contains("valentin"));

    }
}
