package ui.interfaces.dualstates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.character.PlayableCharacter;
import ui.GameUI;
import ui.interfaces.AllScenes;

public class AfterDualInterface extends AllScenes implements EventHandler<ActionEvent> {
    private PlayableCharacter hero;

    public AfterDualInterface(GameUI gameUI, PlayableCharacter hero) {
        super(gameUI);
        this.hero = hero;
        super.initializeGraphics();
    }

    @Override
    protected void initializeRegions() {
        String outcomeString = nameOutcomeString();
        String getTimeString = nameGetTimeString();
        super.createNewLabel(outcomeString);
        super.createNewLabel(getTimeString);
        super.createAdvanceButton("Return", this);
    }

    private String nameOutcomeString() {
        if (hero.getHasWon()) {
            return "Congrats you won!";
        } else {
            return "You died";
        }
    }

    private String nameGetTimeString() {
        if  (hero.getHasWon()) {
            return "Your time was " + hero.getReactionSpeed() + "ms!";
        } else {
            return "You must improve your skills and try again";
        }
    }

    @Override
    public void handle(ActionEvent event) {
        super.gameUI.startOver();
    }
}
