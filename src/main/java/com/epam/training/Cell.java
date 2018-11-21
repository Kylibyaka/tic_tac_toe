package com.epam.training;

public class Cell {

    private String value;

    public Cell() {
        value = " ";
    }

    String getValue() {
        return value;
    }

    void changeToX() {
        value = "X";
    }

    void changeToO() {
        value = "O";
    }

    void print() {
        System.out.print(value);
    }
}
