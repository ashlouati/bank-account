package bdd.steps;

import com.kata.bank.domain.Account;
import com.kata.bank.domain.Amount;
import com.kata.bank.domain.Balance;
import com.kata.bank.domain.BankAccountException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountStepDefs {

    Account account;
    private final List<BankAccountException> caughtExceptions = new ArrayList<>();

    @Given("A new account with an empty balance")
    public void aNewAccountWithAnEmptyBalance() {
        account = new Account();
    }

    @Then("The balance should exactly be equal to {double}")
    public void theBalanceShouldExactlyBeEqualTo(double balance) {
        Balance expectedBalance = new Balance(new BigDecimal(balance));
        assertEquals(expectedBalance, account.getBalance());
    }

    @When("I deposit an amount of {double}")
    public void iDepositAnAmountOf(double amount) {
        try {
            account.deposit(new Amount(new BigDecimal(amount)));
        } catch (BankAccountException exception) {
            caughtExceptions.add(exception);
        }
    }

    @When("I withdraw an amount of {double}")
    public void iWithdrawAnAmountOf(double amount) {
        try {
            account.withdraw(new Amount(new BigDecimal(amount)));
        } catch (BankAccountException exception) {
            caughtExceptions.add(exception);
        }
    }

    @Then("The deposit should be rejected")
    public void theDepositShouldBeRejected() {
        assertFalse(caughtExceptions.isEmpty());
    }


    @Then("The withdrawal should be rejected")
    public void theWithdrawalShouldBeRejected() {
        assertFalse(caughtExceptions.isEmpty());
    }
}
