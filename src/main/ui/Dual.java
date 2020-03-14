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
    private GameUI gameUI;

    private PlayableCharacter hero;
    private Character enemy;

    private HighScoreList gameHighScore;
    private long selectedDifficultly;

    // REQUIRES: selectedDifficulty between 5 and 1
    // EFFECTS: creates a new dual
    public Dual(GameUI gameUI, long selectedDifficultly, HighScoreList gameHighScore) {
        this.gameUI = gameUI;
        this.gameHighScore = gameHighScore;
        this.selectedDifficultly = selectedDifficultly;
        hero = new PlayableCharacter();
        enemy = new NPC();
        new BeforeDualInterface(this.gameUI, this);
    }



    // REQUIRES: selectedDifficulty between 5 and 1
    // MODIFIES: hero, enemy, this
    // EFFECTS: runs the active part of the dual
    public void reactionTimeDual() {
        this.enemy.setReactionSpeed(selectedDifficultly);
        try {
            new ReactionTimerInterface(gameUI, this, hero, enemy);
        } catch (InterruptedException e) {
            System.out.println("ReactionTimerInterface was stopped part way, investigate");
        }
    }

    // MODIFIES: hero, enemy, this
    // EFFECTS: determines what to do if the hero won or lost
    public void afterDual() {
        if (hero.getHasWon()) {
            gameHighScore.addHighScore(hero.getReactionSpeed());
        }
        new AfterDualInterface(gameUI, hero);
    }
}
