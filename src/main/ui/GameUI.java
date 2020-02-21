package ui;

import model.game.HighScoreList;
import persistance.ReadData;
import persistance.SaveData;

import java.util.Scanner;

// (Citation: Process for registering inputs is from the TellerApp)
// Start of new game
public class GameUI {
    private static final String ACCOUNTS_FILE = "./data/highScores.txt";
    public HighScoreList gameHighScores;
    private Scanner input;

    // EFFECTS: Constructs new game
    public GameUI() {
        runNewGame();
    }

    // MODIFIES: input
    // EFFECTS: displays main options and is where the game quits when exit is inputted
    //          also loads previous save data
    private void runNewGame() {
        boolean keepGoing = true;
        String command;
        input = new Scanner(System.in);

        loadSaveHighScores();

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

    // EFFECTS: run corresponding method depending on what user inputs
    private void processCommand(String command) {
        if (command.equals("dual")) {
            startNewDual();
        } else if (command.equals("highscores")) {
            checkHighScores();
        } else if (command.equals("save")) {
            saveHighScores();
        } else {
            System.out.println("The input was as valid as whole foods 'validating' my parking");
        }
    }

    // EFFECTS: displays the main menu to the user to pick what they want to do/see
    private void displayMainMenu() {
        System.out.println("\nChoose One");
        System.out.println("Dual");
        System.out.println("Highscores");
        System.out.println("Save");
        System.out.println("Exit");
    }

    // MODIFIES: this, gameHighScores
    // EFFECTS: If their is save data from a previous session then recreate
    //          the old HighScoreList otherwise create new HighScoreList
    private void loadSaveHighScores() {
        try {
            ReadData data = new ReadData(ACCOUNTS_FILE);
            gameHighScores = data.getSavedHighScores();
        } catch (Exception e) {
            gameHighScores = new HighScoreList();
        }
    }

    // EFFECTS: saves state of HighScoreList
    private void saveHighScores() {
        new SaveData(gameHighScores, ACCOUNTS_FILE);
        System.out.println("Highscores were saved!");
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
        long difficulty;
        String command;
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
