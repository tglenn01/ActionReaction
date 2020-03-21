package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import ui.Dual;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;

// The interface for before a user is prompted to fire
public class BeforeDualInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private Dual dual;

    // MODIFIES: this
    // EFFECTS: Constructs a new DefaultScene
    public BeforeDualInterface(Dual dual) {
        super();
        this.dual = dual;
        super.initializeGraphics();
    }

    @Override
    // EFFECTS: Creates an DefaultButton which has a different style when pressed then other DefaultButtons
    protected void initializeRegions() {
        super.createNewLabel("Press ENTER on the prompt to fire your weapon");
        Button advanceButton = super.createAdvanceButton("Armed and Ready", this);
        advanceButton.setId("beforeFireButton");
    }

    @Override
    // EFFECTS: start the reactionTimeGame
    public void handle(ActionEvent event) {
        dual.reactionTimeDual();
    }
}
