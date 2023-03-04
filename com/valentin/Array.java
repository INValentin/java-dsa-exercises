package com.valentin;

public class Array {

    public static void main(String[] args) {
        Array nums = new Array(2);
        nums.insert(4);
        nums.insert(5);
        nums.print();
    }
    private int[] items;
    private int count = 0;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        items[count] = item;
        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
