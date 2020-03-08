package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import ui.GameUI;
import ui.tools.DualButton;
import ui.tools.HighScoreButton;
import ui.tools.SaveButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainScreenInterface implements EventHandler<ActionEvent> {
    private Button dualButton;
    private Button highScoresButton;
    private Button saveButton;
    private List<Button> mainButtonList;
    private Scene mainScene;
    private GameUI gameUI;


    public MainScreenInterface(GameUI gameUI, int width, int height) {
        this.gameUI = gameUI;
        mainButtonList = new LinkedList<>();
        initializeButtons();
        setScene(width, height);
    }

    private void initializeButtons() {
        dualButton = new DualButton();
        highScoresButton = new HighScoreButton();
        saveButton = new SaveButton();

        mainButtonList = new ArrayList<>();
        mainButtonList.add(dualButton);
        mainButtonList.add(highScoresButton);
        mainButtonList.add(saveButton);

        for (Button icon: mainButtonList) {
            icon.setOnAction(this);
        }
    }

    private void setScene(int width, int height) {
        VBox layout = new VBox();
        layout.getChildren().addAll(mainButtonList);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0);
        mainScene = new Scene(layout, width, height);
    }

    public Scene getMainScene() {
        return mainScene;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == dualButton) {
            gameUI.startNewDual();
        } else if (event.getSource() == highScoresButton) {
            gameUI.checkHighScores();
        } else if (event.getSource() == saveButton) {
            gameUI.saveHighScores();
        }
    }
}
