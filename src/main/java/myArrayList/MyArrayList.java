package myArrayList;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    MyArrayList(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    public void add(T value) {
        if (size == array.length) {
            int newLength = (int)(array.length * 1.5);
            array = Arrays.copyOf(array, newLength);
        }
        array[size++] = value;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return true;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
            size = 0;
        }
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return array[index];
    }
}