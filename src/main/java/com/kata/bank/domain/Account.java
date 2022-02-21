package com.kata.bank.domain;

import java.math.BigDecimal;

public class Account {
    private Balance balance;

    public Account() {
        this.balance = new Balance(BigDecimal.ZERO);
    }

    public Balance getBalance() {
        return balance;
    }

    public void deposit(Amount amount) {
        balance = balance.add(amount);
    }

    public void withdraw(Amount amount) {
        balance = balance.subtract(amount);
    }
}
