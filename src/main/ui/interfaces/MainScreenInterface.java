package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;
import ui.defaultlayouts.DefaultButton;

// The interface where the user is able to see all the options they can choose
public class MainScreenInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private Scene mainScene;
    private Button dualButton;
    private Button highScoresButton;
    private Button saveButton;

    // EFFECTS: Constructs a new DefaultScene
    public MainScreenInterface(GameUI gameUI) {
        super(gameUI);
        super.initializeGraphics();
        storeMainScene();
    }

    // EFFECTS: constructs 3 different buttons to be taken to dual, high score, and save interfaces
    protected void initializeRegions() {
        dualButton = new DefaultButton("Dual!", this);
        highScoresButton = new DefaultButton("High Scores!", this);
        saveButton = new DefaultButton("Save!", this);

        regionList.add(dualButton);
        regionList.add(highScoresButton);
        regionList.add(saveButton);
    }

    @Override
    // EFFECTS: Calls method from gameUI corresponding to each button
    public void handle(ActionEvent event) {
        if (event.getSource() == dualButton) {
            gameUI.selectDifficulty();
        } else if (event.getSource() == highScoresButton) {
            gameUI.checkHighScores();
        } else if (event.getSource() == saveButton) {
            gameUI.saveHighScores();
        }
    }

    // MODIFIES: this
    // EFFECTS: Stores the main screen so GameUI can easily access it when an individual thread finished
    private void storeMainScene() {
        mainScene = super.getNewScene();
    }

    // getter
    public Scene getMainScene() {
        return mainScene;
    }
}
