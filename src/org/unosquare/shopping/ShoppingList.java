package org.unosquare.shopping;

import java.util.HashMap;
import java.util.Locale;

public class ShoppingList {
    private HashMap<String, Integer> productList = new HashMap<String, Integer>();
    void ShoppingList(){
            productList = null;
    }
    public void addProduct(String name,int quantity){
        name = name .toUpperCase(Locale.ROOT);
        if(productAlreadyExists(name)!=true){
            productList.put(name,quantity);
        }else{
            productList.computeIfPresent(name, (key, value) -> value + quantity);

        }
    }
    public boolean productAlreadyExists(String name){
        int counter = productList.size();
        if(productList.get(name)!=null){
            return true;
        }else{
            return false;
        }
    }
    public void showAllProducts(){
        productList.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
    public void showProduct(String name){
       String upperName = name.toUpperCase(Locale.ROOT);
        System.out.println(upperName + " [" +productList.get(upperName)+"]");
    }
}

