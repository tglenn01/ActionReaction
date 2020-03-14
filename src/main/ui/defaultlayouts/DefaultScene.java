package ui.defaultlayouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import ui.GameUI;

import java.util.LinkedList;
import java.util.List;

public abstract class DefaultScene {
    public static final double GAME_HEIGHT = 600.0;
    public static final double GAME_WIDTH = 900.0;
    public static final double SPACING = 10.0;
    public static final String CSS_FILE = "ui/interfaces/actionReactionStylesheet.css";
    protected GameUI gameUI;
    protected Scene newScene;
    protected List<Region> regionList;

    public DefaultScene(GameUI gameUI) {
        this.gameUI = gameUI;
        regionList = new LinkedList<>();
    }

    protected void initializeGraphics() {
        initializeRegions();
        setScene();
    }

    protected abstract void initializeRegions();

    protected void createNewLabel(String text) {
        Label newLabel = new DefaultLabel(text);
        newLabel.setAlignment(Pos.CENTER);
        regionList.add(newLabel);
    }

    protected Button createAdvanceButton(String text, EventHandler<ActionEvent> setHandleTo) {
        Button advanceButton = new DefaultButton(text, setHandleTo);
        regionList.add(advanceButton);
        return advanceButton;
    }

    protected VBox createVerticalList(List list) {
        VBox listLayout = new VBox();
        listLayout.setAlignment(Pos.CENTER);
        listLayout.setSpacing(SPACING);
        listLayout.getChildren().addAll(list);
        regionList.add(listLayout);
        return listLayout;
    }

    protected void createHorizontalList(List list) {
        HBox listLayout = new HBox();
        listLayout.setAlignment(Pos.CENTER);
        listLayout.setSpacing(10.0);
        listLayout.getChildren().addAll(list);
        regionList.add(listLayout);
    }

    protected void setScene() {
        VBox layout = new VBox();
        layout.getChildren().addAll(regionList);
        layout.setSpacing(10.0);
        layout.setAlignment(Pos.CENTER);
        layout.setId("background");
        newScene = new Scene(layout, GAME_WIDTH, GAME_HEIGHT);
        newScene.getStylesheets().add(CSS_FILE);
        gameUI.primaryStage.setScene(newScene);
    }

    protected Scene getNewScene() {
        return newScene;
    }
}
