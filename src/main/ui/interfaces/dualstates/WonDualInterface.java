package ui.interfaces.dualstates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.character.PlayableCharacter;
import ui.GameUI;
import ui.interfaces.MainScreenInterface;
import ui.tools.AdvanceButton;

public class WonDualInterface implements EventHandler<ActionEvent> {
    private PlayableCharacter hero;
    private GameUI gameUI;

    public WonDualInterface(GameUI gameUI, PlayableCharacter hero) {
        this.gameUI = gameUI;
        this.hero = hero;
        setUp();
    }

    private void setUp() {
        Label congratsLabel = new Label("Congrats you won!");
        congratsLabel.setAlignment(Pos.CENTER);

        Label getTimeLabel = new Label("Your time was " + hero.getReactionSpeed() + "ms!");
        congratsLabel.setAlignment(Pos.CENTER);

        Button advanceButton = new AdvanceButton();
        advanceButton.setAlignment(Pos.CENTER);
        advanceButton.setOnAction(this);

        VBox layout = new VBox();
        layout.getChildren().addAll(congratsLabel, getTimeLabel, advanceButton);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0);

        Scene wonScreen = new Scene(layout, GameUI.GAME_WIDTH, GameUI.GAME_HEIGHT);

        gameUI.primaryStage.setScene(wonScreen);
    }

    @Override
    public void handle(ActionEvent event) {
        gameUI.startOver();
    }
}
