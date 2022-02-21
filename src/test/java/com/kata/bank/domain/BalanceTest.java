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
}
