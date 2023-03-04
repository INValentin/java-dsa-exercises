package hash_tables;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static Character firstNonRepeatedChar(String my_str) {
        my_str = my_str.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();

        for (Character character : my_str.toCharArray()) {
            if (map.containsKey(character)) {
                map.remove(character);
                continue;
            }
            map.put(character, 1);
        }

        for (Character character : my_str.toCharArray()) {
            if (map.containsKey(character))
                return character;
        }

        return Character.MIN_VALUE;
    }
}
