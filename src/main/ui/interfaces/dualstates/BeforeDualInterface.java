package ui.interfaces.dualstates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.Dual;
import ui.GameUI;
import ui.tools.AdvanceButton;

public class BeforeDualInterface implements EventHandler<ActionEvent> {
    private GameUI gameUI;
    private Dual dual;
    private Button advanceButton;

    public BeforeDualInterface(GameUI gameUI, Dual dual) {
        this.gameUI = gameUI;
        this.dual = dual;
        setUp();
    }

    private void setUp() {
        Label instructionsLabel = new Label("Press ENTER on the prompt to fire your weapon");
        instructionsLabel.setAlignment(Pos.CENTER);

        advanceButton = new AdvanceButton();
        advanceButton.setOnAction(this);

        VBox layout = new VBox();
        layout.getChildren().addAll(instructionsLabel, advanceButton);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0);

        Scene beforeFireScene = new Scene(layout, GameUI.GAME_WIDTH, GameUI.GAME_HEIGHT);
        gameUI.primaryStage.setScene(beforeFireScene);
    }

    @Override
    public void handle(ActionEvent event) {
        dual.reactionTimeDual();
    }
}
