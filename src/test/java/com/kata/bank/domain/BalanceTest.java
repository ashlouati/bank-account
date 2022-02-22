package com.kata.bank.domain;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BalanceTest {

    @Test
    void should_add_amount_20_to_balance() {
        Balance balance = new Balance(BigDecimal.ZERO);
        Balance newBalance = balance.add(new Amount(new BigDecimal(20)));

        Balance expectedBalance = new Balance(new BigDecimal(20));

        assertEquals(expectedBalance, newBalance);
    }

    @Test
    void should_throw_exception_trying_to_add_negative_amounts() {
        Balance balance = new Balance(BigDecimal.ZERO);

        assertThrows(BankAccountException.class,
                () -> balance.add(new Amount(new BigDecimal(-20))));
    }

    @Test
    void should_subtract_amount_20_from_balance_of_100() {
        Balance balance = new Balance(new BigDecimal(100));
        Balance newBalance = balance.subtract(new Amount(new BigDecimal(20)));

        Balance expectedBalance = new Balance(new BigDecimal(80));

        assertEquals(expectedBalance, newBalance);
    }

    @Test
    void should_throw_exception_trying_to_subtract_amount_greater_than_balance() {
        Balance balance = new Balance(new BigDecimal(20));

        assertThrows(BankAccountException.class,
                () -> balance.subtract(new Amount(new BigDecimal(100))));
    }


}
