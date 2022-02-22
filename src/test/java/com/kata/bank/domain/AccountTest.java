package com.kata.bank.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private final Clock fixedClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    @Test
    void should_create_account_initiated_with_zero_balance() {
        Account account =  new Account();
        Balance expectedBalance = new Balance(BigDecimal.ZERO);

        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void should_deposit_amount_of_100_into_account() {
        Account account = new Account();
        account.deposit(new Amount(new BigDecimal(100)));
        Balance expectedBalance = new Balance(new BigDecimal(100));

        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void should_throw_exception_when_trying_to_deposit_any_negative_amount() {
        Account account = new Account();

        assertThrows(BankAccountException.class,
                () -> account.deposit(new Amount(new BigDecimal(-30))));
    }

    @Test
    void should_withdraw_amount_of_100_from_account_having_balance_of_1000() {
        Account account = new Account();
        account.deposit(new Amount(new BigDecimal(1000)));

        account.withdraw(new Amount(new BigDecimal(100)));
        Balance expectedBalance = new Balance(new BigDecimal(900));

        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void should_throw_exception_when_withdrawal_amount_exceeds_balance() {
        Account account = new Account();

        assertThrows(BankAccountException.class,
                () -> account.withdraw(new Amount(new BigDecimal(100))));
    }

    @Test
    void should_print_deposit_operation() {
        Account account = new Account(fixedClock);
        account.deposit(new Amount(new BigDecimal(340)));
        FakePrinter printer = new FakePrinter();
        account.print(printer);
        Operation expectedOperation = new Operation(
                OperationType.DEPOSIT,
                new Amount(new BigDecimal(340)),
                new Balance(new BigDecimal(340)),
                LocalDateTime.now(fixedClock));
        assertTrue(printer.getOperations().contains(expectedOperation));
    }

}
