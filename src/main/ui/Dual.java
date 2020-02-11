package ui;

import model.character.Character;
import model.character.NPC;
import model.character.PlayableCharacter;
import model.game.HighScoreList;
import static java.lang.Thread.sleep;

// (Citation: http://sub-second.blogspot.com/2012/08/how-to-measure-response-times-in-java.html)

// The dual system in the game runs through here
public class Dual {
    private PlayableCharacter hero;
    private Character enemy;
    private HighScoreList gameHighScore;

    // REQUIRES: selectedDifficulty between 5 and 1
    // EFFECTS: creates a new dual
    public Dual(long selectedDifficultly, HighScoreList gameHighScore) {
        hero = new PlayableCharacter();
        enemy = new NPC();
        beforeDual();
        startOfDual(selectedDifficultly);
        afterDual(gameHighScore);
        resetGame(gameHighScore);
    }

    // EFFECTS: gives the user information on who is fighting and a brief tutorial
    private void beforeDual() {
        System.out.println(hero.getName() + " VS " + enemy.getName());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        System.out.println("press a then enter on !");
    }

    // REQUIRES: selectedDifficulty between 5 and 1
    // MODIFIES: hero, enemy, this
    // EFFECTS: runs the active part of the dual
    private void startOfDual(long selectedDifficultly) {
        this.enemy.setReactionSpeed(selectedDifficultly);
        try {
            new ReactionTimer(hero, enemy);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }


    private void afterDual(HighScoreList gameHighScore) {
        if (hero.getHasWon()) {
            wonDual(gameHighScore);
            System.out.println("Your time was " + hero.getReactionSpeed());
        } else {
            lostDual();
        }
    }

    private void wonDual(HighScoreList gameHighScore) {
        enemy.die();
        hero.win();
        gameHighScore.addHighScore(hero.getReactionSpeed());
    }

    private void lostDual() {
        hero.die();
        enemy.win();
    }

    private void resetGame(HighScoreList gameHighScore) {
        new GameUI(gameHighScore);
    }
}