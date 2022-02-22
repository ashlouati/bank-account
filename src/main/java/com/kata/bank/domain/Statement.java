package com.kata.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private final List<Operation> operations = new ArrayList<>();

    public void add(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
