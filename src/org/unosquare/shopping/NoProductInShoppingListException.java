package org.unosquare.shopping;

public class NoProductInShoppingListException extends Exception{
    public NoProductInShoppingListException(String errorMessage) {
        super(errorMessage);
    }
}
