import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Objects.requireNonNull;

/**
 * Custom implementation of HashMap
 *
 * @author ahmad.fajar
 * @see java.util.HashMap
 */
public class NewMap<K, V> {

    /**
     * Hash table for lists of map elements
     */
    private ArrayList<NewEntry<K, V>>[] hashTable;

    /**
     * Default capacity of the hash table
     */
    private final int defaultSize = 10;
    private int size = 0;

    private static class NewEntry<K, V> {
        K key;
        V value;

        public NewEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value) {
            V temp = this.value;
            this.value = value;
            return temp;
        }
    }

    /**
     * Returns index of bucket in hash table
     * @param   key key of the value
     * @return      index of bucket in hash table
     */
    private int indexBucket(Object key) {
        return key.hashCode() % hashTable.length;
    }

    public NewMap() {
        hashTable = new ArrayList[defaultSize];
        for (int i = 0; i < defaultSize; i++) {
            hashTable[i] = new ArrayList<>();
        }
    }

    /**
     * Returns size of collection
     * @return  size
     */
    public int size() {
        return size;
    }

    /**
     * Check if the map is empty
     * @return  true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if the key is in map
     * @param key   key of value
     * @return  true or false
     * @throws NullPointerException If the key is null
     */
    public boolean containsKey(Object key) {
        requireNonNull(key);

        int index = indexBucket(key);

        return hashTable[index].stream()
                .anyMatch((e) -> e.getKey().equals(key));
    }

    /**
     * Check if the value is in map
     * @param value value which must be in map
     * @return  true or false
     * @throws NullPointerException If the value is null
     */
    public boolean containsValue(Object value) {
        requireNonNull(value);

        return Arrays.stream(hashTable)
                .anyMatch((l) -> l.stream()
                        .anyMatch((e) -> e.getValue().equals(value)));
    }

    /**
     * Ruturns value by the key
     * @param key   the key of value
     * @return  value by the key or null
     * @throws NullPointerException If the key is null
     */
    public V get(Object key) {
        requireNonNull(key);

        int index = indexBucket(key);

        for (NewEntry<K, V> entry : hashTable[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Put the key and the value in map.
     * @param key   key of the value
     * @param value value of the map element
     * @return  old value by the key or null
     * @throws  NullPointerException If a key or value is null
     */
    public V put(K key, V value) {
        requireNonNull(key);
        requireNonNull(value);

        int index = indexBucket(key);

        for (NewEntry<K, V> entry : hashTable[index]) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        hashTable[index].add(new NewEntry<K, V>(key, value));
        size++;
        return null;
    }
}