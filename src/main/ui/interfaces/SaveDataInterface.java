package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.GameUI;
import ui.tools.AdvanceButton;

public class SaveDataInterface implements EventHandler<ActionEvent> {
    private GameUI gameUI;

    public SaveDataInterface(GameUI gameUI) {
        this.gameUI = gameUI;
        setUp();
    }

    private void setUp() {
        Label saveLabel = new Label("Data Saved");
        saveLabel.setAlignment(Pos.CENTER);

        Button advanceButton = new AdvanceButton();
        advanceButton.setOnAction(this);
        advanceButton.setAlignment(Pos.CENTER);

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0);
        layout.getChildren().addAll(saveLabel, advanceButton);

        Scene saveScene = new Scene(layout, GameUI.GAME_WIDTH, GameUI.GAME_HEIGHT);
        gameUI.primaryStage.setScene(saveScene);
    }

    @Override
    public void handle(ActionEvent event) {
        gameUI.startOver();
    }
}
