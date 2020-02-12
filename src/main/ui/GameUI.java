package ui;

import model.game.HighScoreList;

import java.util.Scanner;

// Process for registering inputs is from the TellerApp
// Start of new game
public class GameUI {
    public HighScoreList gameHighScores;
    private Scanner input;

    // MODIFIES: gameHighScore
    // EFFECTS: Constructs new game
    public GameUI(HighScoreList highScoreList) {
        gameHighScores = highScoreList;
        runNewGame();
    }

    // MODIFIES: input
    // EFFECTS: displays main options and is where the game quits when exit is inputted
    private void runNewGame() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMainMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("exit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
    }

    // MODIFIES: command
    // EFFECTS: run corresponding method depending on what user inputs
    private void processCommand(String command) {
        if (command.equals("dual")) {
            startNewDual();
        } else if (command.equals("highscores")) {
            checkHighScores();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays the main menu to the user to pick what they want to do/see
    private void displayMainMenu() {
        System.out.println("\nChoose One");
        System.out.println("Dual");
        System.out.println("Highscores");
        System.out.println("exit");
    }

    // EFFECTS: starts a new dual after selecting new game
    private void startNewDual() {
        long selectedDifficulty = selectDifficulty();
        new Dual(selectedDifficulty, gameHighScores);
    }

    // EFFECTS: shows all the high scores from the play session
    private void checkHighScores() {
        int listLength = 0;
        for (long score : gameHighScores.highScoreList) {
            listLength++;
            System.out.println(listLength + ") " + score + "ms");
        }
    }

    // MODIFIES: this
    // EFFECTS: gives the user the option to choose how hard the dual will be
    private long selectDifficulty() {
        long difficulty = 0;
        String command = null;
        System.out.println("Choose your difficulty\n" + "1, 2, 3, 4, 5");
        command = input.next();
        if (command.equals("1")) {
            difficulty = 1;
        } else if (command.equals("2")) {
            difficulty = 2;
        } else if (command.equals("3")) {
            difficulty = 3;
        } else if (command.equals("4")) {
            difficulty = 4;
        } else if (command.equals("5")) {
            difficulty = 5;
        } else {
            difficulty = 1;
            System.out.println("Wow that's on a whole different level that I can't comprehend");
            runNewGame();
        }
        return difficulty;
    }
}
