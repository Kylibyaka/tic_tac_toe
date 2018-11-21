package com.epam.training;


public class Field {
    private Cell[][] field;

    public Field() {
        field = new Cell[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    void print() {
        System.out.println("\n  1 2 3");
        for (int i = 0; i < field.length; i++) {
            System.out.println("  - - - ");
            System.out.print((i + 1) + "|");
            for (int j = 0; j < 3; j++) {
                if (field[i][j].getValue() == null) {
                    System.out.print(" " + "|");
                } else {
                    field[i][j].print();
                    System.out.print("|");
                }

            }
            System.out.println();
        }
        System.out.println("  - - - ");
    }

    boolean changeCell(int x, int y, int player) {
        if (field[x][y].getValue().equals(" ")) {
            if (player == 1)
                field[x][y].changeToX();
            else
                field[x][y].changeToO();
            return true;
        }
        System.out.println("There is a value in the cell");
        return false;
    }

    boolean checkWin() {
        int[] countArray = new int[4];
        countArray[2] = 0;
        countArray[3] = 0;

        for (int i = 0; i < 3; i++) {
            countArray[0] = 0;
            countArray[1] = 0;

            for (int j = 0; j < 3; j++) {
                if (field[i][j].getValue().equals("X")) {
                    countArray[0]++;
                } else if (field[i][j].getValue().equals("O")) {
                    countArray[0]--;
                }
                if (field[j][i].getValue().equals("X")) {
                    countArray[1]++;
                } else if (field[j][i].getValue().equals("O")) {
                    countArray[1]--;
                }
            }
            if (field[i][i].getValue().equals("X")) {
                countArray[2]++;
            } else if (field[i][i].getValue().equals("O")) {
                countArray[2]--;
            }
            if (field[i][2 - i].getValue().equals("X")) {
                countArray[3]++;
            } else if (field[i][2 - i].getValue().equals("O")) {
                countArray[3]--;
            }
            for (int c : countArray) {
                if (Math.abs(c) == 3)
                    return true;
            }
        }
        return false;
    }
}
