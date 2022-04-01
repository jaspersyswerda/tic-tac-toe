package com.jasper;

import java.util.Random;
import java.util.Scanner;

public class TTT {

    String[] board = new String[9];

    public static void main(String[] args) {
        TTT ttt = new TTT();
        ttt.makeBoard();
        ttt.play();
    }

    private void makeBoard() {
        for (int i = 0;i<9;i++){
            board[i] = String.valueOf(i+1);
        }
    }

    //PrintBoard
    // | 1 | 2 | 3 |
    // | 4 | 5 | 6 |
    // | 7 | 8 | 9 |

    private void printBoard() {

        for (int i = 0;i<9;i++){
            System.out.print("| ");
            System.out.print(board[i] + " ");
            if (i == 2 || i == 5){
                System.out.print("|");
                System.out.println();
            }
        }
        System.out.print("|");
        System.out.println();
        System.out.println();
    }

    private void play() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("X will play first.");
        printBoard();
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        while (!gameEnded){
            playerTurn(scanner);
            gameEnded = checkGameEnded();
            printBoard();
            computerTurn();
            gameEnded = checkGameEnded();
            printBoard();
        }
        scanner.close();
    }

    private void playerTurn(Scanner scanner) {
        int move;
        do {
            System.out.println("What is your move? 1-9");
            move = scanner.nextInt();
        } while (!validMove(move));
        board[move-1] = "X";
    }

    private void computerTurn() {
        int move;
        do {
            Random rand = new Random();
            move = rand.nextInt(9);
        } while (!validMove(move));
        board[move-1] = "O";
    }

    private boolean validMove(int move) {
        return move >= 1 && move <= 9 &&
         board[move-1] != "X" && board[move-1] != "O";
    }

    private boolean checkGameEnded() {
        //TODO: implement
        return false;
    }
}