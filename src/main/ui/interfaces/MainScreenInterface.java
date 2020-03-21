package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;
import ui.defaultlayouts.DefaultButton;

// The interface where the user is able to see all the options they can choose
public class MainScreenInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private Button dualButton;
    private Button highScoresButton;
    private Button saveButton;

    // EFFECTS: Constructs a new DefaultScene
    public MainScreenInterface() {
        super();
    }

    // EFFECTS: constructs 3 different buttons to be taken to dual, high score, and save interfaces
    protected void initializeRegions() {
        dualButton = new DefaultButton("Dual!", this);
        highScoresButton = new DefaultButton("High Scores!", this);
        saveButton = new DefaultButton("Save!", this);

        super.regionList.add(dualButton);
        super.regionList.add(highScoresButton);
        super.regionList.add(saveButton);
    }

    @Override
    // EFFECTS: Calls method from gameUI corresponding to each button
    public void handle(ActionEvent event) {
        if (event.getSource() == dualButton) {
            GameUI.getInstance().selectDifficulty();
        } else if (event.getSource() == highScoresButton) {
            GameUI.getInstance().checkHighScores();
        } else if (event.getSource() == saveButton) {
            GameUI.getInstance().saveHighScores();
        }
    }
}
