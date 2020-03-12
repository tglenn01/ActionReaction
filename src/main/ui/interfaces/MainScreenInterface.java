package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import ui.GameUI;
import ui.defaultlayouts.DefaultButton;


public class MainScreenInterface extends AllScenes implements EventHandler<ActionEvent> {
    private Scene mainScene;
    private Button dualButton;
    private Button highScoresButton;
    private Button saveButton;

    public MainScreenInterface(GameUI gameUI) {
        super(gameUI);
        super.initializeGraphics();
        storeMainScene();
    }

    protected void initializeRegions() {
        dualButton = new DefaultButton("Dual!", this);
        highScoresButton = new DefaultButton("High Scores!", this);
        saveButton = new DefaultButton("Save!", this);

        regionList.add(dualButton);
        regionList.add(highScoresButton);
        regionList.add(saveButton);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == dualButton) {
            gameUI.selectDifficulty();
        } else if (event.getSource() == highScoresButton) {
            gameUI.checkHighScores();
        } else if (event.getSource() == saveButton) {
            gameUI.saveHighScores();
        }
    }

    private void storeMainScene() {
        mainScene = super.getNewScene();
    }

    public Scene getMainScene() {
        return mainScene;
    }
}
