package com.epam.training;

public class Cell {
    enum Value {EMPTY, X, O}
    private Value value;

    public Cell() {
        value = Value.EMPTY;
    }

    Value getValue() {
        return value;
    }

    void changeToX() {
        value = Value.X;
    }

    void changeToO() {
        value = Value.O;
    }

    void print() {
        System.out.print(value);
    }
}
