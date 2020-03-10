package ui;

import model.character.Character;
import model.character.NPC;
import model.character.PlayableCharacter;
import model.game.HighScoreList;
import ui.interfaces.dualstates.BeforeDualInterface;
import ui.interfaces.dualstates.LostDualInterface;
import ui.interfaces.dualstates.ReactionTimerInterface;
import ui.interfaces.dualstates.WonDualInterface;

import static java.lang.Thread.sleep;

// The dual system in the game runs through here
public class Dual {
    private PlayableCharacter hero;
    private Character enemy;
    private GameUI gameUI;
    private HighScoreList gameHighScore;
    private long selectedDifficultly;

    // REQUIRES: selectedDifficulty between 5 and 1
    // EFFECTS: creates a new dual
    public Dual(GameUI gameUI, long selectedDifficultly, HighScoreList gameHighScore,
                int width, int height) {
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
            wonDual();
        } else {
            lostDual();
        }
    }

    // MODIFIES: gameHighScores, enemy
    // EFFECTS: enemy dies, hero wins, gameHighScores is added to the HighScoreList
    private void wonDual() {
        gameHighScore.addHighScore(hero.getReactionSpeed());
        new WonDualInterface(gameUI, hero);
    }

    // MODIFIES: hero
    // EFFECTS: hero dies and enemy wins
    private void lostDual() {
        new LostDualInterface(gameUI);
    }
}
