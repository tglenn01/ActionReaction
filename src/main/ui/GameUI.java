package ui;

import javafx.stage.Stage;
import model.game.HighScoreList;
import persistance.ReadData;
import persistance.SaveData;
import ui.interfaces.*;

import java.io.IOException;

// Sources: https://docs.oracle.com/javafx/2/layout/size_align.htm
//        : http://tutorials.jenkov.com/javafx/index.html
//
// Start of new game.
public class GameUI {
    private static final String ACCOUNTS_FILE = "./data/highScores.txt";
    private Stage primaryStage;
    private static GameUI gameUI;

    // EFFECTS: Constructs new game
    private GameUI() {
        loadSaveHighScores();
    }

    // EFFECTS: creates a new instance of gameUI if none created otherwise return one and only gameUI
    public static GameUI getInstance() {
        if (gameUI == null) {
            gameUI = new GameUI();
        }
        return gameUI;
    }

    // MODIFIES: this, gameHighScores
    // EFFECTS: If their is save data from a previous session then recreate
    //          the old HighScoreList otherwise create new HighScoreList
    private void loadSaveHighScores() {
        try {
            new ReadData(ACCOUNTS_FILE);
        } catch (Exception e) {
            HighScoreList.getInstance();
        }
    }

    // EFFECTS: saves state of HighScoreList
    public void saveHighScores() {
        try {
            new SaveData(ACCOUNTS_FILE);
        } catch (IOException e) {
            return;
        }
        new SaveDataInterface();
    }

    // EFFECTS: starts a new dual after selecting new game
    public void startNewDual(long selectedDifficulty) {
        new Dual(selectedDifficulty);
    }

    // EFFECTS: shows all the high scores
    public void checkHighScores() {
        new HighScoreListInterface();
    }

    // EFFECTS: gives the user the option to choose how hard the dual will be
    public void selectDifficulty() {
        new SelectDifficultyInterface();
    }

    // MODIFIES: this
    // EFFECTS: sets the user's screen back to the main screen
    public void startOver() {
        new MainScreenInterface();
    }

    // setter
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // getter
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
