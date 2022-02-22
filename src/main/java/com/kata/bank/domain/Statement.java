package com.kata.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private final List<StatementLine> statementLines = new ArrayList<>();

    public void add(Operation operation, Balance balance) {
        statementLines.add(new StatementLine(operation, balance));
    }

    public List<StatementLine> getStatementLines() {
        return statementLines;
    }
}
