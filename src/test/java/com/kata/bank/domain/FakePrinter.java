package com.kata.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class FakePrinter implements Printer {

    private final List<StatementLine> statementLines = new ArrayList<>();

    @Override
    public void print(Statement statement) {
        statementLines.addAll(statement.getStatementLines());
    }

    public List<StatementLine> getStatementLines() {
        return statementLines;
    }
}
