package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;

// The interface where a user is told that their data was saved successfully
public class SaveDataInterface extends DefaultScene implements EventHandler<ActionEvent> {

    // EFFECTS: Constructs a new DefaultScene
    public SaveDataInterface() {
        super();
    }

    // EFFECTS: creates a label confirming the save, then a but to return to the main screen
    protected void initializeRegions() {
        super.createNewLabel("High Scores were saved!");
        super.createAdvanceButton("Return", this);
    }

    @Override
    // EFFECTS: returns to the main screen
    public void handle(ActionEvent event) {
        GameUI.getInstance().startOver();
    }
}
