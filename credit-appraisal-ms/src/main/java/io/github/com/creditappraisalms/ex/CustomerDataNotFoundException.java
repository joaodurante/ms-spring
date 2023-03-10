package io.github.com.creditappraisalms.ex;

public class CustomerDataNotFoundException extends Exception {
    public CustomerDataNotFoundException() {
        super("Customer not found for the given CPF");
    }
}
