package hash_tables;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingChar {
    private static Set<Character> set = new HashSet<>();

    public static Character firstRepeatedChar(String myString) {
        myString = myString.toLowerCase();

        for (Character character : myString.toCharArray()) {
            if (set.contains(character))
                return character;
            set.add(character);
        }

        return Character.MIN_VALUE;
    }
}
