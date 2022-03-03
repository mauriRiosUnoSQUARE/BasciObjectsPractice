package org.unosquare.shopping;

public class NonExistingNameException extends Exception{
    public NonExistingNameException(String errorMessage) {
        super(errorMessage);
    }
}
