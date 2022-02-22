package com.kata.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class FakePrinter implements Printer {

    private final List<Operation> operations = new ArrayList<>();

    @Override
    public void print(Statement statement) {
        operations.addAll(statement.getOperations());
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
