package com.epam.training;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        new Game().game();
    }
}

class Game {
    void game() {
        Scanner in = new Scanner(System.in);
        boolean win;
        boolean game = true;
        while (game) {
            Field field = new Field();
            int player = 1, x, y, winner = 0;
            win = false;
            while (!win) {

                field.print();

                System.out.format("Enter coords (x,y) for %d player: ", player);
                try {
                    x = in.nextInt();
                    y = in.nextInt();
                    if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
                        if (!field.changeCell(x - 1, y - 1, player)) {
                            continue;
                        }
                    } else {
                        System.out.println("Wrong coords.");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    in.next();
                }

                win = field.checkWin();
                winner = player;
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            }

            field.print();

            System.out.format("Player %d win! Play again? (y/n): ", winner);
            if (in.next().equals("n")) {
                game = false;
            }
        }
    }
}
