package org.unosquare.shopping;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ShoppingList myList = new ShoppingList();
        myList.addProduct("rice",1);
        myList.addProduct("noodles",1);
        myList.addProduct("coke",1);
        myList.addProduct("rice",1);
        // myList.showProducts();
        Scanner input = new Scanner(System.in);
        String value = input.next();
        myList.showProduct(value);
    }
}
