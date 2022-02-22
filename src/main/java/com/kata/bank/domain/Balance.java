package com.kata.bank.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Balance {
    private final BigDecimal value;

    public Balance(BigDecimal value) {
        this.value = value;
    }

    public Balance add(Amount amount) {
        validateAmount(amount);
        return new Balance(value.add(amount.getValue()));
    }

    public Balance subtract(Amount amount) {
        validateAmount(amount);
        validateBalance(amount);
        return new Balance(value.subtract(amount.getValue()));
    }

    private void validateAmount(Amount amount) {
        if(amount != null && amount.getValue().signum() == -1) {
            throw new BankAccountException("negative Amounts cannot be added to Balance!");
        }
    }

    private void validateBalance(Amount amount) {
        if(value.compareTo(amount.getValue()) < 0) {
            throw new BankAccountException("the Amount to subtract exceeds the Balance");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return value.equals(balance.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
