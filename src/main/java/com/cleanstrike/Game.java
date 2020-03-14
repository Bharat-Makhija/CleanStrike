package com.cleanstrike;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class Game {

    private Player playerA;
    private Player playerB;
    private Board board;
    private Player currentPlayer;
    private String currentPlayerName;

    @Getter
    private Map stats;

    public Game(Player playerA, Player playerB, Board board) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.board = board;
        stats = new HashMap<String, String>();
        currentPlayer = playerA;
        currentPlayerName = Constants.PLAYER_A;
        System.out.println("\n--------------------------");
        System.out.println("---------NEW GAME---------");
        System.out.println("--------------------------");
        System.out.println("Welcome to the Clean Strike game.");
    }

    public void play(final int[] input) {
        int i = 0;

        System.out.println("Choices of a player: ");
        System.out.println("1. Strike");
        System.out.println("2. Multi-Strike");
        System.out.println("3. Red Strike");
        System.out.println("4. Striker Strike");
        System.out.println("5. Defunct Coin");
        System.out.println("6. None");

        while(i < input.length) {
            board.setPlayer(currentPlayer);
            int ch = input[i];
            System.out.println("\nChoice of " + currentPlayerName + ": " + ch);
            switch (ch) {
                case 1: {
                    board.strike();
                    break;
                }
                case 2: {
                    board.multiStrike();
                    break;
                }
                case 3: {
                    board.redStrike();
                    break;
                }
                case 4: {
                    board.strikerStrike();
                    break;
                }
                case 5: {
                    board.defunctCoin();
                    break;
                }
                case 6: {
                    board.noStrike();
                    break;
                }
                default: {
                    System.out.println("Invalid input.");
                    continue;
                }
            }
            if(isGameOver())
                break;
            System.out.println("Score (A - B): " + playerA.getScore() + " - " + playerB.getScore());
            i++;
            changePlayer();
        }
        declareResults();
    }

    private boolean isGameOver() {
        int scorePlayerA = playerA.getScore();
        int scorePlayerB = playerB.getScore();
        int redCoins = board.getRedCoins();
        int blackCoins = board.getBlackCoins();

        if(scorePlayerA >= 5 && scorePlayerA - scorePlayerB >= 3) {
            stats.put(Constants.OUTCOME, Constants.FOUND_WINNER);
            stats.put(Constants.WINNER, Constants.PLAYER_A);
            return true;
        }

        if(scorePlayerB >= 5 && scorePlayerB - scorePlayerA >= 3) {
            stats.put(Constants.OUTCOME, Constants.FOUND_WINNER);
            stats.put(Constants.WINNER, Constants.PLAYER_B);
            return true;
        }

        if(blackCoins == 0 && redCoins == 0) {
            stats.put(Constants.OUTCOME, Constants.DRAW);
            return true;
        }

        return false;
    }

    private void changePlayer() {
        if(currentPlayer.equals(playerB)) {
            currentPlayer = playerA;
            currentPlayerName = "Player A";
        }
        else {
            currentPlayer = playerB;
            currentPlayerName = "Player B";
        }
    }

    private void declareResults() {
        if(stats.containsKey(Constants.OUTCOME)) {
            if(stats.get(Constants.OUTCOME) == Constants.FOUND_WINNER) {
                System.out.println(stats.get(Constants.WINNER) + " has won the game!");
                System.out.println("Final Score (A - B): " + playerA.getScore() + " - " + playerB.getScore());
            }
            else
                System.out.println("The game is draw!");
        }
        else
            System.out.println("Input exhausted. Game ended prematurely.");
    }

}
