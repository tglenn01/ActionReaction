package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ui.GameUI;
import ui.tools.DifficultyButton;

import java.util.LinkedList;
import java.util.List;


public class SelectDifficultyInterface implements EventHandler<ActionEvent> {
    private static final int MAX_DIFFICULTY = 5;
    private List<DifficultyButton> difficultyList;
    private int selectedDifficulty;
    private Scene difficultyScene;
    private GameUI gameUI;

    public SelectDifficultyInterface(GameUI gameUI, int width, int height) {
        this.gameUI = gameUI;
        selectedDifficulty = 1;
        difficultyList = new LinkedList<>();
        initialiseDifficultyButtons();
        setScene(width, height);
    }

    private void initialiseDifficultyButtons() {
        for (int i = 1; i <= MAX_DIFFICULTY; i++) {
            DifficultyButton difficultyButton = new DifficultyButton(i, this);
            difficultyList.add(difficultyButton);
        }
    }

    private void setScene(int width, int height) {
        Label label = new Label("Choose Your Difficulty!");

        HBox horizontalLayout = new HBox();
        horizontalLayout.setAlignment(Pos.CENTER);
        horizontalLayout.setSpacing(10.0);
        horizontalLayout.getChildren().addAll(difficultyList);

        VBox verticalLayout = new VBox();
        verticalLayout.setAlignment(Pos.CENTER);
        verticalLayout.setSpacing(10.0);
        verticalLayout.getChildren().addAll(label, horizontalLayout);

        difficultyScene = new Scene(verticalLayout, width, height);
    }

    @Override
    public void handle(ActionEvent event) {
        for (DifficultyButton difficultyButton: difficultyList) {
            if (event.getSource() == difficultyButton) {
                selectedDifficulty = difficultyButton.getButtonDifficulty();
                gameUI.startNewDual(selectedDifficulty);
            }
        }
    }

    public Scene getDifficultyScene() {
        return difficultyScene;
    }
}