package com.kata.bank.domain;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public class Account {
    private final Clock clock;
    private Balance balance;
    private final Statement statement = new Statement();

    public Account() {
        this.balance = new Balance(BigDecimal.ZERO);
        this.clock = Clock.systemDefaultZone();
    }

    public Account(Clock clock) {
        this.clock = clock;
        this.balance = new Balance(BigDecimal.ZERO);
    }

    public Balance getBalance() {
        return balance;
    }

    public void deposit(Amount amount) {
        balance = balance.add(amount);
        statement.add(new Operation(OperationType.DEPOSIT, amount, LocalDateTime.now(clock)), balance);
    }

    public void withdraw(Amount amount) {
        balance = balance.subtract(amount);
        statement.add(new Operation(OperationType.WITHDRAWAL, amount, LocalDateTime.now(clock)), balance);
    }

    public void print(Printer printer) {
        printer.print(statement);
    }
}
