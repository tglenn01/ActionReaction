package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import model.game.HighScoreList;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;
import ui.defaultlayouts.DefaultLabel;

import java.util.ArrayList;
import java.util.List;

// The interface when a user is looking at their highscores
public class HighScoreListInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private HighScoreList gameHighScores;

    // MODIFIES: this
    // EFFECTS: Constructs a new DefaultScene
    public HighScoreListInterface(HighScoreList gameHighScores) {
        super();
        this.gameHighScores = gameHighScores;
        super.initializeGraphics();
    }

    // EFFECTS: Creates a VBox of DefaultLabels and puts it on top of a DefaultButton
    protected void initializeRegions() {
        List<Label> scoreList = new ArrayList<>();
        int listLength = 0;
        for (long score : gameHighScores.highScoreList) {
            listLength++;
            Label scoreLabel = new DefaultLabel(listLength + ") " + score + "ms");
            scoreList.add(scoreLabel);
        }
        super.createVerticalList(scoreList);
        super.createAdvanceButton("Return", this);
    }

    @Override
    // EFFECTS: returns the user to the mainScreenInterface
    public void handle(ActionEvent event) {
        GameUI.getInstance().startOver();
    }
}
