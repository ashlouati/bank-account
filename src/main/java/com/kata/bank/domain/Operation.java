package com.kata.bank.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {

    private final OperationType deposit;
    private final Amount amount;
    private final Balance balance;
    private final LocalDateTime timestamp;

    public Operation(OperationType deposit, Amount amount, Balance balance, LocalDateTime timestamp) {
        this.deposit = deposit;
        this.amount = amount;
        this.balance = balance;
        this.timestamp = timestamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return deposit == operation.deposit && Objects.equals(amount, operation.amount) && Objects.equals(balance, operation.balance) && Objects.equals(timestamp, operation.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deposit, amount, balance, timestamp);
    }
}
