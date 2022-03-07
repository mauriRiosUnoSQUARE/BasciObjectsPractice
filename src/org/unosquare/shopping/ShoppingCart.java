package org.unosquare.shopping;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ShoppingCart {
    private ShoppingList thingsToBuy = new ShoppingList();
    private HashSet<Product> productsToBuy = new HashSet<Product>();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    double subTotal,taxes,totalValue;
    public ShoppingCart(){
        thingsToBuy.addProduct("rice",1);
        thingsToBuy.addProduct("noodles",1);
        thingsToBuy.addProduct("coke",1);
        thingsToBuy.addProduct("rice",1);
        thingsToBuy.addProduct("water",1);
        taxes=0;
        subTotal=0;
        totalValue=0;
    }
    void AddProductsToSet(String name, double price){
        name = name.toUpperCase(Locale.ROOT);
        Product newItem = new Product();
        newItem.setName(name);
        newItem.setPrice(price);
        //System.out.println(newItem.getName() +" "+newItem.getPrice());
        try{
            if(thingsToBuy.productAlreadyExists(name) && checkProductsInSet(name).get() ){

                    productsToBuy.add(newItem);
            }
            else {
                throw new NoProductInShoppingListException("Product isn't in the ShoppingList");
            }
        } catch (NoProductInShoppingListException e) {
            System.out.println(e.getMessage());
        } ;
    }
    void validateIfExists(String nameInSet, String nameFromItem) throws RepeatedNameInCartException {
       if(nameFromItem == nameInSet){
           throw new RepeatedNameInCartException("Product isn't in the ShoppingList");
       }
    }
    AtomicBoolean checkProductsInSet(String name){
        AtomicBoolean productExists = new AtomicBoolean(false);
        AtomicBoolean productNotExists = new AtomicBoolean(true);
            productsToBuy.forEach((item)-> {
                try {
                    validateIfExists(item.getName(),name);
                    if(item.getName() == name){
                        throw new RepeatedNameInCartException("Product isn't in the ShoppingList");
                    }else{
                        productNotExists.set(true);
                    }
                } catch (RepeatedNameInCartException e) {
                    System.out.println(e.getMessage());

                }
            });
        return productNotExists;
    };
    void showProductsInSet(){
        productsToBuy.forEach((item)-> {
            System.out.println(item.getName()+"-"+item.getPrice());
        });
    };
    void calculateTaxes(){
        AtomicReference<Double> preSubTotal = new AtomicReference<>((double) 0);
        productsToBuy.forEach((item)-> {
            preSubTotal.set(preSubTotal.get() + item.getPrice());
        });
        subTotal=preSubTotal.get();
        taxes=subTotal*0.15;
        totalValue = taxes+subTotal;
    }
    void showPricingData(){
        calculateTaxes();
        System.out.println("SubTotal: $"+df.format(Math.round(subTotal)));
        System.out.println("Taxes: $"+df.format(Math.floor(taxes)));
        System.out.println("TOTAL: $"+df.format(Math.ceil(totalValue)));
    }
}
