package ui.interfaces.dualstates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import ui.Dual;
import ui.GameUI;
import ui.interfaces.AllScenes;

public class BeforeDualInterface extends AllScenes implements EventHandler<ActionEvent> {
    private Dual dual;

    public BeforeDualInterface(GameUI gameUI, Dual dual) {
        super(gameUI);
        this.dual = dual;
        super.initializeGraphics();
    }

    @Override
    protected void initializeRegions() {
        super.createNewLabel("Press ENTER on the prompt to fire your weapon");
        super.createAdvanceButton("Next", this);
    }


    @Override
    public void handle(ActionEvent event) {
        dual.reactionTimeDual();
    }
}
