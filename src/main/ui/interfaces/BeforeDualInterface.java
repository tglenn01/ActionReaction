package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import ui.Dual;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;

public class BeforeDualInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private Dual dual;

    public BeforeDualInterface(GameUI gameUI, Dual dual) {
        super(gameUI);
        this.dual = dual;
        super.initializeGraphics();
    }

    @Override
    protected void initializeRegions() {
        super.createNewLabel("Press ENTER on the prompt to fire your weapon");
        Button advanceButton = super.createAdvanceButton("Armed and Ready", this);
        advanceButton.setId("beforeFireButton");
    }

    @Override
    public void handle(ActionEvent event) {
        dual.reactionTimeDual();
    }
}
