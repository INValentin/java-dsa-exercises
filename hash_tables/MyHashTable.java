package hash_tables;

import java.util.LinkedList;

public class MyHashTable<Key, Val> {
    private class Pair<K, V> {
        private K key;
        private V value;

        Pair(K ke, V val) {
            key = ke;
            value = val;
        }
    }

    private LinkedList<Pair<Key, Val>>[] myArray = new LinkedList[10];

    private int hashFunction(Key key) {
        int len = myArray.length;

        int index = Integer.MIN_VALUE;
        if (key instanceof String) {
            int count = 0;
            for (Character ch : key.toString().toCharArray()) {
                count += (int) ch;
            }
            index = count % len;

        } else if (key instanceof Integer)
            index = (int) key % len;
        else if (key instanceof Character)
            index = (int) key % len;
        else
            throw new IllegalArgumentException();

        return index;

    }

    public void put(Key key, Val value) {
        int index = hashFunction(key);

        if (myArray[index] instanceof LinkedList) {
            myArray[index].add(new Pair<Key, Val>(key, value));
        } else {
            LinkedList<Pair<Key, Val>> linkedList = new LinkedList<>();
            linkedList.add(new Pair<Key, Val>(key, value));
            myArray[index] = linkedList;
        }
    }

    public Val get(Key key) {
        int index = hashFunction(key);
        var linkedList = myArray[index];

        if (!(linkedList instanceof LinkedList)) {
            throw new IllegalArgumentException();
        }

        for (Pair<Key, Val> pair : linkedList) {
            if (pair.key == key)
                return pair.value;
        }

        throw new IllegalArgumentException();
    }

    public boolean contains(Key key) {
        try {
            get(key);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void remove(Key key) {
        int index = hashFunction(key);
        var linkedList = myArray[index];

        if (!(linkedList instanceof LinkedList)) {
            throw new IllegalArgumentException();
        }

        if (!linkedList.removeIf(pair -> pair.key == key))
            throw new IllegalArgumentException();
    }

}
