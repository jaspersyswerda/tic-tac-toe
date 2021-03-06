package com.jasper;

import java.util.Random;
import java.util.Scanner;

public class TTT {

   private String[] board = new String[9];

    public static void main(String[] args) {
        TTT ttt = new TTT();
        ttt.makeBoard();
        ttt.play();
    }

    protected void makeBoard() {
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

    protected void play() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        Player humanPlayer = new Player(true,"X");
        Player computer = new Player(false, "O");
        printBoard();
        System.out.printf("%s will play first.%n", humanPlayer.getMark());
        Scanner scanner = new Scanner(System.in);
        while (true){
            playerTurn(humanPlayer, scanner);
            printBoard();
            if (checkGameEnded(humanPlayer)) break;
            playerTurn(computer, scanner);
            printBoard();
            if (checkGameEnded(computer)) break;
        }
        scanner.close();
    }

    private void playerTurn(Player player, Scanner scanner) {
        try{
            Integer move = null;
            do {
                if (player.isHumanPlayer()){
                    if (move != null){
                        System.out.println("That is not a valid number. Try again please.");
                    }
                    System.out.println("What is your move? [1-9]");
                    move = Integer.parseInt(scanner.next());
                }
                else {
                    Random rand = new Random();
                    move = rand.nextInt(9);
                }
            } while (!validMove(move));
            if (player.isHumanPlayer()) {
                System.out.printf("Player move is %d.%n", move);
            } else {
                System.out.printf("Computer move is %d.%n", move);
            }
            board[move-1] = player.getMark();
        } catch (NumberFormatException nfe){
            System.out.println("That is not a valid number. Try again please.");
            playerTurn(player, scanner);
        }
    }

    private boolean validMove(int move) {
        return move >= 1 && move <= 9 &&
         !"X".equals(board[move-1]) && !"O".equals(board[move-1]);
    }

    private boolean checkGameEnded(Player player) {
        if (winnerHorizontally() || winnerVertically() || winnerDiagonally()){
            if (player.isHumanPlayer()) System.out.println("Player won!");
            else System.out.println("Computer won!");
            return true;
        }
        return boardFull();
    }

    private boolean winnerHorizontally() {
        return (board[0].equals(board[1]) && board[1].equals(board[2])) ||
                (board[3].equals(board[4]) && board[4].equals(board[5])) ||
                (board[6].equals(board[7]) && board[7].equals(board[8]));
    }

    private boolean winnerVertically() {
        return (board[0].equals(board[3]) && board[3].equals(board[6])) ||
                (board[1].equals(board[4]) && board[4].equals(board[7])) ||
                (board[2].equals(board[5]) && board[5].equals(board[8]));
    }

    private boolean winnerDiagonally(){
        return (board[0].equals(board[4]) && board[4].equals(board[8])) ||
                (board[2].equals(board[4]) && board[4].equals(board[6]));
    }

    private boolean boardFull(){
        for (String number : board){
            if (!"X".equals(number) && !"O".equals(number)){
                return false;
            }
        }
        System.out.println("Board full, game tied!");
        return true;
    }

    public String[] getBoard() {
        return board;
    }
}