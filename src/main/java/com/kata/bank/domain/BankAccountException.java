package com.kata.bank.domain;

public class BankAccountException extends RuntimeException {
    public BankAccountException(String message) {
        super(message);
    }
}
