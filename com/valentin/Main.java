package com.valentin;

public class Main {
    public static void main(String[] args) {
        String[] myArgStrings = {"", ""};
        Array.main(myArgStrings);
        Array myArray = new Array(5);
        myArray.insert(10);

        System.out.println("This is main!");
        myArray.print();
    }
}
