package ui;

import model.character.Character;
import model.character.NPC;
import model.character.PlayableCharacter;
import model.game.HighScoreList;
import ui.interfaces.BeforeDualInterface;
import ui.interfaces.ReactionTimerInterface;
import ui.interfaces.AfterDualInterface;


// The dual system in the game runs through here
public class Dual {
    private PlayableCharacter hero;
    private Character enemy;

    private long selectedDifficultly;

    // MODIFIES: this
    // EFFECTS: creates a new dual while setting all given parameters
    public Dual(long selectedDifficultly) {
        this.selectedDifficultly = selectedDifficultly;
        hero = new PlayableCharacter();
        enemy = new NPC();
        new BeforeDualInterface(this);
    }

    // MODIFIES: hero, enemy, this
    // EFFECTS: runs the active part of the dual
    public void reactionTimeDual() {
        this.enemy.setReactionSpeed(selectedDifficultly);
        try {
            new ReactionTimerInterface(this, hero, enemy);
        } catch (InterruptedException e) {
            System.out.println("ReactionTimerInterface was stopped part way, investigate");
        }
    }

    // MODIFIES: this
    // EFFECTS: determines what to do if the hero won or lost
    public void afterDual() {
        if (hero.getHasWon()) {
            HighScoreList.getInstance().addHighScore(hero.getReactionSpeed());
        }
        new AfterDualInterface(hero);
    }
}
