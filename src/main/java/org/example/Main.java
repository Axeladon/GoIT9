package org.example;

import myHashMap.MyHashMap;
import myLinkedList.MyLinkedList;
import myStack.MyStack;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("Ivan", 50);
        hashMap.put("ludmila", 100);
        hashMap.put("ludmili", 200);
        hashMap.remove("ludmila");
        System.out.println(hashMap.get("ludmili"));


    }

}