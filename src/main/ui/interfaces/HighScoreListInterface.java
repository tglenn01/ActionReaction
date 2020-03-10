package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.game.HighScoreList;
import ui.GameUI;
import ui.tools.AdvanceButton;

import java.util.ArrayList;
import java.util.List;

public class HighScoreListInterface implements EventHandler<ActionEvent> {
    private HighScoreList gameHighScores;
    private GameUI gameUI;

    public HighScoreListInterface(GameUI gameUI, HighScoreList gameHighScores) {
        this.gameUI = gameUI;
        this.gameHighScores = gameHighScores;
        setUp();
    }

    private void setUp() {
        List<Label> labelList = new ArrayList<>();
        int listLength = 0;
        for (long score : gameHighScores.highScoreList) {
            listLength++;
            Label label = new Label(listLength + ") " + score + "ms");
            label.setAlignment(Pos.CENTER);
            labelList.add(label);
        }

        Button advanceButton = new AdvanceButton();
        advanceButton.setAlignment(Pos.CENTER);
        advanceButton.setOnAction(this);

        VBox scoreLayout = new VBox();
        scoreLayout.setAlignment(Pos.CENTER);
        scoreLayout.setSpacing(10.0);
        scoreLayout.getChildren().addAll(labelList);

        VBox wholeLayout = new VBox();
        wholeLayout.setAlignment(Pos.CENTER);
        wholeLayout.setSpacing(10.0);
        wholeLayout.getChildren().addAll(scoreLayout, advanceButton);

        Scene highScoreScene = new Scene(wholeLayout, GameUI.GAME_WIDTH, GameUI.GAME_HEIGHT);
        gameUI.primaryStage.setScene(highScoreScene);
    }

    @Override
    public void handle(ActionEvent event) {
        gameUI.startOver();
    }
}
