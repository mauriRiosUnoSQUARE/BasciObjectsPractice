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
    public int deleteProduct(String name){

        try{
            if(name == null){
                throw new NullNameException("Product name must not be null");
            }
            else if(name == ""){
                throw new EmptyNameException("Product name must not be an empty string");
            }
            else if(productList.get(name.toUpperCase(Locale.ROOT)) == null){
                throw new NonExistingNameException("Product doesn't exists in the list");
            }
            else
            {
                String upperName = name.toUpperCase(Locale.ROOT);
                int amountOfItemsTobeRemoved=productList.get(upperName);
                productList.remove(upperName,amountOfItemsTobeRemoved);
                return amountOfItemsTobeRemoved;
            }

        }
        catch (EmptyNameException e){
         //   System.out.println(e.getMessage());
            return 0;
        }catch (NonExistingNameException e){
       //     System.out.println(e.getMessage());
            return 0;
        }catch (NullNameException e){
       //     System.out.println(e.getMessage());
            return 0;
        }
    };
}

