package com.kata.bank.domain;

import com.kata.bank.infrastructure.ConsolePrinter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsolePrinterTest {

    private final Clock fixedClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    DateTimeFormatter frenchDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final String HEADER = "| OPERATION | DATE | AMOUNT | BALANCE |\n";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void should_print_on_console_statement_lines() {
        Account account = new Account();
        account.deposit(new Amount(new BigDecimal(3000)));
        account.print(new ConsolePrinter());
        String formattedDateTime = LocalDateTime.now(fixedClock).format(frenchDateTimeFormatter);
        String expectedOutput = HEADER +
                "| DEPOSIT | " + formattedDateTime + " | 3000 | 3000 |";

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
