package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.game.HighScoreList;
import ui.GameUI;
import ui.defaultlayouts.DefaultLabel;

import java.util.ArrayList;
import java.util.List;

public class HighScoreListInterface extends AllScenes implements EventHandler<ActionEvent> {
    private HighScoreList gameHighScores;

    public HighScoreListInterface(GameUI gameUI, HighScoreList gameHighScores) {
        super(gameUI);
        this.gameHighScores = gameHighScores;
        super.initializeGraphics();
    }

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
    public void handle(ActionEvent event) {
        super.gameUI.startOver();
    }
}
