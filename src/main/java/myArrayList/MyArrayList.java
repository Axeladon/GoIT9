package myArrayList;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public MyArrayList(int capacity) {
        array = (T[]) new Object[capacity];
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
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return true;
    }

    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

}