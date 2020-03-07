package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.game.HighScoreList;
import persistance.ReadData;
import persistance.SaveData;
import ui.tools.HighScoreButton;
import ui.tools.DualButton;
import ui.tools.SaveButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// (Citation: Process for registering inputs is from the TellerApp)
// Sources: https://docs.oracle.com/javafx/2/layout/size_align.htm
//
// Start of new game
public class GameUI extends Application implements EventHandler<ActionEvent> {
    private static final String ACCOUNTS_FILE = "./data/highScores.txt";
    private static final int GAME_HEIGHT = 500;
    private static final int GAME_WIDTH = 500;

    public HighScoreList gameHighScores;

    public Button dualButton;
    public Button highScoresButton;
    public Button saveButton;
    public List<Button> buttonList;



    // EFFECTS: Constructs new game
    public GameUI(Stage primaryStage) throws Exception {
        loadSaveHighScores();
        start(primaryStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Action Reaction!");

        initializeButtons();

        VBox layout = new VBox(dualButton, highScoresButton, saveButton);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0);

        Scene scene = new Scene(layout, GAME_WIDTH, GAME_HEIGHT);
        primaryStage.setScene(scene);
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
    private void saveHighScores() {
        try {
            new SaveData(gameHighScores, ACCOUNTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving high scores");
            return;
        }
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
        return 1; // Stub
    }

    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == dualButton) {
            startNewDual();
        } else if (event.getSource() == highScoresButton) {
            checkHighScores();
        } else if (event.getSource() == saveButton) {
            saveHighScores();
        }
    }

    private void initializeButtons() {
        dualButton = new DualButton();
        highScoresButton = new HighScoreButton();
        saveButton = new SaveButton();

        buttonList = new ArrayList<>();
        buttonList.add(dualButton);
        buttonList.add(highScoresButton);
        buttonList.add(saveButton);

        for (Button icon: buttonList) {
            icon.setOnAction(this);
        }

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
