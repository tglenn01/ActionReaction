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

// All scenes adhere to this implementation to keep all scenes consistent
public abstract class DefaultScene {
    public static final double GAME_HEIGHT = 600.0;
    public static final double GAME_WIDTH = 900.0;
    public static final double SPACING = 10.0;
    public static final String CSS_FILE = "ui/defaultlayouts/actionReactionStylesheet.css";
    protected GameUI gameUI;
    protected Scene newScene;
    protected List<Region> regionList;

    // MODIFIES: this
    // EFFECTS: sets the gameUI to given gameUI and creates a new List for the regionList
    public DefaultScene(GameUI gameUI) {
        this.gameUI = gameUI;
        regionList = new LinkedList<>();
    }

    // EFFECTS: sets up the graphics
    protected void initializeGraphics() {
        initializeRegions();
        setScene();
    }

    protected abstract void initializeRegions();

    // MODIFIES: this
    // EFFECTS: creates a new DefaultLabel and adds it to the regionList
    //          returns Label in case the class calling the method needs further modification
    protected Label createNewLabel(String text) {
        Label newLabel = new DefaultLabel(text);
        regionList.add(newLabel);
        return newLabel;
    }

    // MODIFIES: this
    // EFFECTS: creates a new DefaultButton and adds it to the region list
    //          returns Button in case the class calling the method needs further modification
    protected Button createAdvanceButton(String text, EventHandler<ActionEvent> setHandleTo) {
        Button advanceButton = new DefaultButton(text, setHandleTo);
        regionList.add(advanceButton);
        return advanceButton;
    }

    // MODIFIES: this
    // EFFECTS: creates a new VBox with given list and adds it to the region list
    //          returns VBox in case the class calling the method needs further modification
    protected VBox createVerticalList(List list) {
        VBox listLayout = new VBox();
        listLayout.setAlignment(Pos.CENTER);
        listLayout.setSpacing(SPACING);
        listLayout.getChildren().addAll(list);
        regionList.add(listLayout);
        return listLayout;
    }

    // MODIFIES: this
    // EFFECTS: creates a new HBox with given list and adds it to the region list
    //          returns HBox in case the class calling the method needs further modification
    protected HBox createHorizontalList(List list) {
        HBox listLayout = new HBox();
        listLayout.setAlignment(Pos.CENTER);
        listLayout.setSpacing(10.0);
        listLayout.getChildren().addAll(list);
        regionList.add(listLayout);
        return listLayout;
    }

    // MODIFIES: primaryStage
    // EFFECTS: creates a VBox with all the regions in regionList then displays that VBox to primaryStage
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

    // getter
    protected Scene getNewScene() {
        return newScene;
    }
}
