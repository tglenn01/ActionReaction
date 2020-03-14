package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;

public class SaveDataInterface extends DefaultScene implements EventHandler<ActionEvent> {

    public SaveDataInterface(GameUI gameUI) {
        super(gameUI);
        super.initializeGraphics();
    }


    protected void initializeRegions() {
        super.createNewLabel("High Scores were saved!");
        super.createAdvanceButton("Return", this);
    }

    @Override
    public void handle(ActionEvent event) {
        gameUI.startOver();
    }
}
