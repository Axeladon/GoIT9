package myHashMap;

import java.util.Arrays;


public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % buckets.length;
        Entry entry = new Entry(key, value);
        if (buckets[index] == null) {
            buckets[index] = entry;
        } else {
            Entry current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = entry;
            }
        }
        size++;
    }

    public void remove(String key) {
        int hash = key.hashCode();
        int index = hash % buckets.length;
        Entry current = buckets[index];
        Entry prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object get(K key) {
        if (key == null) {
            return null;
        }
        int hash = key.toString().hashCode();
        int index = hash % buckets.length;
        Entry current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
