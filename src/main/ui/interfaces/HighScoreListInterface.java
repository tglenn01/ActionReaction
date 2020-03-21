package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.game.HighScoreList;
import ui.GameUI;
import ui.defaultlayouts.DefaultButton;
import ui.defaultlayouts.DefaultScene;
import ui.defaultlayouts.DefaultLabel;

import java.util.ArrayList;
import java.util.List;

// The interface when a user is looking at their highscores
public class HighScoreListInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private DefaultButton returnButton;
    private DefaultButton clearDataButton;

    // MODIFIES: this
    // EFFECTS: Constructs a new DefaultScene
    public HighScoreListInterface() {
        super();
        super.initializeGraphics();
    }

    // EFFECTS: Creates a VBox of DefaultLabels and puts it on top of a DefaultButton
    protected void initializeRegions() {
        List<Label> scoreList = new ArrayList<>();
        int listLength = 0;
        for (long score : HighScoreList.getInstance().getScoreList()) {
            listLength++;
            Label scoreLabel = new DefaultLabel(listLength + ") " + score + "ms");
            scoreList.add(scoreLabel);
        }
        super.createVerticalList(scoreList);

        List<Button> buttonList = new ArrayList<>();
        returnButton = new DefaultButton("Return", this);
        buttonList.add(returnButton);
        if (HighScoreList.getInstance().getScoreList().size() != 0) {
            clearDataButton = new DefaultButton("Clear Scores", this);
            buttonList.add(clearDataButton);
        }
        super.createHorizontalList(buttonList);
    }

    @Override
    // EFFECTS: returns the user to the mainScreenInterface
    public void handle(ActionEvent event) {
        if (event.getSource() == clearDataButton) {
            HighScoreList.getInstance().clearHighScoreList();
            GameUI.getInstance().saveHighScores();
        }
        GameUI.getInstance().startOver();
    }
}
