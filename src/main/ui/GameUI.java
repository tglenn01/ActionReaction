package ui;

import model.game.HighScoreList;

// Start of new game
public class GameUI {
    private HighScoreList gameHighScores;

    public GameUI() {
        gameHighScores = new HighScoreList();
    }

    private void processCommand(String command) {
        if (command.equals("new game")) {
            startNewDual();
        } else if (command.equals("high scores")) {
            checkHighScores();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays the main menu to the user to pick what they want to do/see
    private void displayMainMenu() {
        System.out.println("\nChoose One");
        System.out.println("\nnew game");
        System.out.println("\nhigh scores");
    }

    // EFFECTS: starts a new dual after selecting new game
    private void startNewDual() {
        double selectedDifficulty = selectDifficulty();
        new Dual(selectedDifficulty);
    }

    // EFFECTS: shows all the high scores from the play session
    private void checkHighScores() {
        int listLength = 0;
        for (double score : gameHighScores.highScoreList) {
            System.out.println(listLength + gameHighScores.getHighScore(listLength) + "\n");
            listLength++;
        }
    }

    // MODIFIES: this
    // EFFECTS: gives the user the option to choose how hard the dual will be
    private double selectDifficulty() {
        double difficulty = 0;
        System.out.println("Choose your difficulty\n" + "1, 2, 3, 4, 5");
        if (command.equals(1)) {
            difficulty = 1;
        } else if (command.equals(2)) {
            difficulty = 2;
        } else if (command.equals(3)) {
            difficulty = 3;
        } else if (command.equals(4)) {
            difficulty = 4;
        } else if (command.equals(5)) {
            difficulty = 5;
        } else {
            System.out.println("Wow that's on a whole different level that I can't comprehend");
        }
        return difficulty;
    }
}
