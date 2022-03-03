package org.unosquare.shopping;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ShoppingList myList = new ShoppingList();
        myList.addProduct("rice",1);
        myList.addProduct("noodles",1);
        myList.addProduct("coke",1);
        myList.addProduct("rice",1);
        System.out.println(myList.deleteProduct(null));
        System.out.println(myList.deleteProduct("noExisto"));
        System.out.println(myList.deleteProduct(""));
        myList.showAllProducts();
        System.out.println(myList.deleteProduct("COKE"));
        myList.showAllProducts();
        Scanner input = new Scanner(System.in);
        String value = input.next();
        myList.showProduct(value);

    }
}
