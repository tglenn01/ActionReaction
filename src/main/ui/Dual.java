package ui;

import model.character.Character;
import model.character.NPC;
import model.character.PlayableCharacter;

import java.util.concurrent.TimeUnit;

// The dual system in the game runs through here
public class Dual {
    private Character hero;
    private Character enemy;

    // REQUIRES: selectedDifficulty between 5 and 1
    // EFFECTS: creates a new dual
    public Dual(double selectedDifficultly) {
        Character hero = new PlayableCharacter();
        Character enemy = new NPC();
        beforeDual();
        startOfDual(selectedDifficultly);
        afterDual();
    }

    // EFFECTS: gives the user information on who is fighting and a brief tutorial
    private void beforeDual() {
        System.out.println(hero.getName() + "\nVS" + enemy.getName());
        System.out.println("press space on !");
    }

    // REQUIRES: selectedDifficulty between 5 and 1
    // MODIFIES: hero, enemy, this
    // EFFECTS: runs the active part of the dual
    private void startOfDual(double selectedDifficultly) {
        this.enemy.setReactionSpeed(selectedDifficultly);
        double timeLeft = this.enemy.getReactionSpeed();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("!");
        while (timeLeft > 0) {

        }
        this.hero.setReactionSpeed(this.enemy.getReactionSpeed() - timeLeft);
    }

    private void afterDual() {
        //stub
    }
}
