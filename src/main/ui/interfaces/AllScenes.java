package ui.interfaces;

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
import ui.defaultlayouts.DefaultButton;
import ui.defaultlayouts.DefaultLabel;

import java.util.LinkedList;
import java.util.List;

public abstract class AllScenes {
    public static final int GAME_HEIGHT = 500;
    public static final int GAME_WIDTH = 500;
    public static final double SPACING = 10.0;
    protected GameUI gameUI;
    protected Scene newScene;
    protected List<Region> regionList;

    public AllScenes(GameUI gameUI) {
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
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10.0);
        layout.getChildren().addAll(regionList);
        newScene = new Scene(layout, GAME_WIDTH, GAME_HEIGHT);
        styleBackground(newScene);
        gameUI.primaryStage.setScene(newScene);
    }

    protected void styleBackground(Scene newScene) {

    }


    protected Scene getNewScene() {
        return newScene;
    }
}
