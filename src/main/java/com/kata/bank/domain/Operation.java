package com.kata.bank.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {

    private final OperationType operationType;
    private final Amount amount;
    private final LocalDateTime timestamp;

    public Operation(OperationType operationType, Amount amount, LocalDateTime timestamp) {
        this.operationType = operationType;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType && Objects.equals(amount, operation.amount) && Objects.equals(timestamp, operation.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, amount, timestamp);
    }
}
