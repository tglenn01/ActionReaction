package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.character.PlayableCharacter;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;

// The interface for after someone has pressed fire and shows them if they won or lost
public class AfterDualInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private PlayableCharacter hero;

    // MODIFIES: this
    // EFFECTS: Constructs a new DefaultScene
    public AfterDualInterface(GameUI gameUI, PlayableCharacter hero) {
        super(gameUI);
        this.hero = hero;
        super.initializeGraphics();
    }

    @Override
    // EFFECTS: creates a label for if the user won or lost then gives them their time if they won
    //          also gives the button to allow the user to return to the main screen
    protected void initializeRegions() {
        String outcomeString = nameOutcomeString();
        String getTimeString = nameGetTimeString();
        super.createNewLabel(outcomeString);
        super.createNewLabel(getTimeString);
        super.createAdvanceButton("Return", this);
    }

    // EFFECTS: returns a string which will be displayed depending on if the user won or not
    private String nameOutcomeString() {
        if (hero.getHasWon()) {
            return "Congrats you won!";
        } else {
            return "You died";
        }
    }

    // EFFECTS: returns a string which will have the users reaction time if won or a motivational line if they lost
    private String nameGetTimeString() {
        if  (hero.getHasWon()) {
            return "Your time was " + hero.getReactionSpeed() + "ms!";
        } else {
            return "You must improve your skills and try again";
        }
    }

    @Override
    // EFFECTS: returns the user to the mainScreenInterface
    public void handle(ActionEvent event) {
        super.gameUI.startOver();
    }
}
