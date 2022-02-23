package bdd.steps;

import com.kata.bank.domain.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountStepDefs {

    private Account account;
    private  FakePrinter printer;

    private final String instantExpected = "2022-02-23T18:43:00Z";
    private final Clock fixedClock = Clock.fixed(Instant.parse(instantExpected), ZoneId.systemDefault());
    private final DateTimeFormatter frenchDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final List<BankAccountException> caughtExceptions = new ArrayList<>();


    @Given("A new account with an empty balance")
    public void aNewAccountWithAnEmptyBalance() {
        account = new Account(fixedClock);
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

    @When("I print the statement")
    public void iPrintTheStatement() {
        printer = new FakePrinter();
        account.print(printer);
    }

    @Then("Console should print the following")
    public void consoleShouldPrintTheFollowing(DataTable dataTable) {
        List<StatementLine> expectedStatementLines = dataTable.asMaps().stream()
                .map(table -> new StatementLine(
                    new Operation(
                            OperationType.valueOf(table.get("OPERATION")),
                            new Amount(new BigDecimal(table.get("AMOUNT"))),
                            LocalDateTime.parse(table.get("DATE"), frenchDateTimeFormatter)),
                    new Balance(new BigDecimal(table.get("BALANCE")))))
                .collect(Collectors.toList());
        assertEquals(expectedStatementLines , printer.getStatementLines());
    }
}
