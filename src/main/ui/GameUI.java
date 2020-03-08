package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.game.HighScoreList;
import persistance.ReadData;
import persistance.SaveData;
import ui.interfaces.MainScreenInterface;
import ui.interfaces.SelectDifficultyInterface;

import java.io.IOException;

// (Citation: Process for registering inputs is from the TellerApp)
// Sources: https://docs.oracle.com/javafx/2/layout/size_align.htm
//
// Start of new game
public class GameUI extends Application {
    private static final String ACCOUNTS_FILE = "./data/highScores.txt";
    private static final int GAME_HEIGHT = 500;
    private static final int GAME_WIDTH = 500;

    public HighScoreList gameHighScores;

    private Stage primaryStage;


    // EFFECTS: Constructs new game
    public GameUI(Stage primaryStage) throws Exception {
        loadSaveHighScores();
        start(primaryStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Action Reaction!");

        MainScreenInterface msi = new MainScreenInterface(this, GAME_WIDTH, GAME_HEIGHT);

        primaryStage.setScene(msi.getMainScene());
        primaryStage.show();
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
    public void saveHighScores() {
        try {
            new SaveData(gameHighScores, ACCOUNTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving high scores");
            return;
        }
        System.out.println("Highscores were saved!");
    }

    // EFFECTS: starts a new dual after selecting new game
    public void startNewDual() {
        long selectedDifficulty = selectDifficulty();
        new Dual(selectedDifficulty, gameHighScores);
    }

    // EFFECTS: shows all the high scores from the play session
    public void checkHighScores() {
        int listLength = 0;
        for (long score : gameHighScores.highScoreList) {
            listLength++;
            System.out.println(listLength + ") " + score + "ms");
        }
    }

    // MODIFIES: this
    // EFFECTS: gives the user the option to choose how hard the dual will be
    private long selectDifficulty() {
        Object dummyObj = new Object();
        SelectDifficultyInterface difficulty = new SelectDifficultyInterface(dummyObj, GAME_WIDTH, GAME_HEIGHT);
        Scene difficultyScene = difficulty.getDifficultyScene();
        primaryStage.setScene(difficultyScene);
        try {
            synchronized (dummyObj) {
                dummyObj.wait();
            }
        } catch (Exception e) {
            System.out.println("exception");
        }
        return difficulty.getSelectedDifficulty();
    }

    /*
    Todo for next time!
     Great job super proud of you btw
     so first start with setDifficulty()
     then create a screen for saved data worked
     then once that is up and running create the high scores page
     and lastly work on the actual dual since that will require the most comfort
     Great Job!
     */
}
