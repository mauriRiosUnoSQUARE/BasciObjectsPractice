package org.unosquare.shopping;

public class RepeatedNameInCartException extends Exception{
    public RepeatedNameInCartException(String errorMessage) {
        super(errorMessage);
    }
}
