package com.kata.bank.infrastructure;

import com.kata.bank.domain.Printer;
import com.kata.bank.domain.Statement;

import java.time.format.DateTimeFormatter;

public class ConsolePrinter implements Printer {

    DateTimeFormatter frenchDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final String HEADER = "| OPERATION | DATE | AMOUNT | BALANCE |\n";

    @Override
    public void print(Statement statement) {
        StringBuilder printedLines = new StringBuilder(HEADER);
        statement.getStatementLines()
                .forEach(statementLine -> printedLines.append(
                        String.format("| %s | %s | %s | %s |\n",
                                statementLine.getOperation().getOperationType(),
                                statementLine.getOperation().getTimestamp().format(frenchDateTimeFormatter),
                                statementLine.getOperation().getAmount(),
                                statementLine.getBalance())));
        System.out.println(printedLines);
    }
}
