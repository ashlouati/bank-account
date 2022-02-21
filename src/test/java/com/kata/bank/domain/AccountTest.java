package com.kata.bank.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    void should_create_account_initiated_with_zero_balance() {
        Account account =  new Account();
        Balance expectedBalance = new Balance(BigDecimal.ZERO);

        assertEquals(expectedBalance, account.getBalance());
    }
}
