package org.example;

import myArrayList.MyArrayList;
import myHashMap.MyHashMap;
import myLinkedList.MyLinkedList;
import myQueue.MyQueue;
import myStack.MyStack;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void testMyArrayList() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.get(100);
        for (int i = 0; i < 1_000_000; i++) {
            myArrayList.add(i);
            if (i == 500_000) {
                myArrayList.clear();
            }
        }
        System.out.println("myArrayList.size() = " + myArrayList.size());
        myArrayList.remove(0);
        System.out.println("myArrayList.size() = " + myArrayList.size());
        System.out.println("myArrayList.get(0) = " + myArrayList.get(0));
    }

    public static void testMyHashMap(){
        MyHashMap<Integer, Integer> hashMap = new MyHashMap();

        //check put, get and remove null-key
        hashMap.put(null, 20);
        System.out.println("hashMap.get(null) = " + hashMap.get(null));
        hashMap.remove(null);
        System.out.println("hashMap.get(null) = " + hashMap.get(null));


        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(i, i);
            if (i == 500_000) {
                hashMap.clear();
                hashMap.put(null, i);
            }
        }
        System.out.println("hashMap.size() = " + hashMap.size());
        hashMap.remove(100);
        System.out.println("hashMap.size() = " + hashMap.size());
        hashMap.remove(500_002);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashMap.get(500_005) = " + hashMap.get(500_005));
        System.out.println("hashMap.get(500_000) = " + hashMap.get(500_000));
    }

    public static void testMyLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 1_000_000; i++) {
            myLinkedList.add(i);
            if (i == 500_000) {
                myLinkedList.clear();
            }
        }
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        myLinkedList.remove(100);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println("myLinkedList.get(499_888) = " + myLinkedList.get(499_888));
    }

    public static void testMyQueue() {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 1_000_000; i++) {
            myQueue.add(i);
            if (i == 500_000) {
                myQueue.clear();
            }
        }
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.size() = " + myQueue.size());
    }

    public static void testMyStack() {
        MyStack myStack = new MyStack();
        for (int i = 0; i < 1_000_000; i++) {
            myStack.push(i);
            if (i == 500_000) {
                myStack.clear();
            }
        }
        System.out.println("myLinkedList.size() = " + myStack.size());
        System.out.println("myQueue.peek() = " + myStack.peek());
        System.out.println("myQueue.peek() = " + myStack.peek());
        System.out.println("myQueue.peek() = " + myStack.peek());
        System.out.println("myLinkedList.size() = " + myStack.size());
        System.out.println("myQueue.poll() = " + myStack.pop());
        System.out.println("myQueue.poll() = " + myStack.pop());
        System.out.println("myQueue.poll() = " + myStack.pop());
        System.out.println("myLinkedList.size() = " + myStack.size());

    }

    public static void main(String[] args) {
        testMyArrayList();
        //testMyHashMap();
        //testMyLinkedList();
        //testMyQueue();
    }

}