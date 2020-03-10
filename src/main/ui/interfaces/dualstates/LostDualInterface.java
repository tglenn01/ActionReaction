package ui.interfaces.dualstates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.GameUI;
import ui.interfaces.MainScreenInterface;
import ui.tools.AdvanceButton;

public class LostDualInterface implements EventHandler<ActionEvent> {
    private GameUI gameUI;

    public LostDualInterface(GameUI gameUI) {
        this.gameUI = gameUI;
        setUp();
    }

    private void setUp() {
        Label lostLabel = new Label("You died a terrible death");
        lostLabel.setAlignment(Pos.CENTER);

        Button advanceButton = new AdvanceButton();
        advanceButton.setAlignment(Pos.CENTER);
        advanceButton.setOnAction(this);

        VBox layout = new VBox();
        layout.getChildren().addAll(lostLabel, advanceButton);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0);

        Scene lostScene = new Scene(layout, GameUI.GAME_WIDTH, GameUI.GAME_HEIGHT);
        gameUI.primaryStage.setScene(lostScene);


    }

    @Override
    public void handle(ActionEvent event) {
        gameUI.startOver();
    }
}
