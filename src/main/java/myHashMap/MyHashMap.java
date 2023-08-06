package myHashMap;

import java.util.Arrays;


public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Entry[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private void resizeTable() {
        int newCapacity = buckets.length * 2;
        Entry<K, V>[] newBuckets = new Entry[newCapacity];

        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> entry = buckets[i];
            while (entry != null) {
                int index = entry.key.hashCode() % newCapacity;
                Entry<K, V> next = entry.next;
                entry.next = newBuckets[index];
                newBuckets[index] = entry;
                entry = next;
            }
        }
        buckets = newBuckets;
    }

    public void put(K key, V value) {
        int index = 0;
        if (key != null) {
            index = key.hashCode() % buckets.length;
        }

        Entry<K, V> entry = buckets[index];

        while (entry != null) {
            if (key != null && entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        if (size >= buckets.length * LOAD_FACTOR)
            resizeTable();

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
        size++;
    }

    public void remove(K key) {
        if (key == null) {
            if (buckets[0] != null) {
                buckets[0] = buckets[0].next;
                size--;
            }
            return;
        }

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
    public V get(K key) {
        if (key == null) {
            if (buckets[0] != null) {
                return (V) buckets[0].value;
            } else {
                return null;
            }
        }

        int hash = key.hashCode();
        int index = hash % buckets.length;
        Entry current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return (V)current.value;
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
