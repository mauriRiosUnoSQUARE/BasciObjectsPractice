package org.unosquare.shopping;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*ShoppingList myList = new ShoppingList();
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
        myList.showProduct(value);*/
        ShoppingCart myCart = new ShoppingCart();
        myCart.AddProductsToSet("Chicken",7.22);
        myCart.AddProductsToSet("Meat",4.27);
        myCart.AddProductsToSet("Chicken",1.82);
        myCart.AddProductsToSet("Meat",1.92);
        myCart.AddProductsToSet("Noodles",44.42);
        myCart.showProductsInSet();
        System.out.println("xxxx");
        myCart.AddProductsToSet("NOODLES",1.22);
        myCart.AddProductsToSet("RICE",1.22);
        myCart.AddProductsToSet("WATER",1.22);
        myCart.showProductsInSet();
        myCart.showPricingData();
    }
}
