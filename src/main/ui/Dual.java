package ui;

import model.character.Character;
import model.character.NPC;
import model.character.PlayableCharacter;
import model.game.HighScoreList;
import static java.lang.Thread.sleep;

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
        System.out.println("type draw then press enter on !");
    }

    // REQUIRES: selectedDifficulty between 5 and 1
    // MODIFIES: hero, enemy, this
    // EFFECTS: runs the active part of the dual
    private void startOfDual(long selectedDifficultly) {
        this.enemy.setReactionSpeed(selectedDifficultly);
        try {
            new ReactionTimer(hero, enemy);
        } catch (InterruptedException e) {
            System.out.println("Someone has stopped the dual: Oh no it's a magic attack!");
        }
    }

    // MODIFIES: hero, enemy, this
    // EFFECTS: determines what to do if the hero won or lost
    private void afterDual(HighScoreList gameHighScore) {
        if (hero.getHasWon()) {
            wonDual(gameHighScore);
            System.out.println("Your time was " + hero.getReactionSpeed() + "ms");
        } else {
            lostDual();
        }
    }

    // MODIFIES: gameHighScores, enemy
    // EFFECTS: enemy dies, hero wins, gameHighScores is added to the HighScoreList
    private void wonDual(HighScoreList gameHighScore) {
        System.out.println(enemy.die());
        System.out.println(hero.win());
        System.out.println("You Won!");
        gameHighScore.addHighScore(hero.getReactionSpeed());
    }

    // MODIFIES: hero
    // EFFECTS: hero dies and enemy wins
    private void lostDual() {
        System.out.println(hero.die());
        System.out.println(enemy.win());
        System.out.println("You Died! Try again next time.");
    }

    // EFFECTS: starts anew game with the updated HighScoreList
    private void resetGame(HighScoreList gameHighScore) {
        new GameUI(gameHighScore);
    }
}
