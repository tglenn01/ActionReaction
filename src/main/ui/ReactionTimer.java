package ui;

import model.character.Character;
import model.character.PlayableCharacter;

import java.util.Scanner;
import static java.lang.Thread.sleep;

public class ReactionTimer {
    long reactionTime;

    // MODIFIES: hero
    // EFFECTS: win dual if ui inputs the action faster than the enemy's reaction speed
    ReactionTimer(PlayableCharacter hero, Character enemy) throws InterruptedException {
        String command = null;
        Scanner input = new Scanner(System.in);

        sleep(5000);

        System.out.println("!");
        long milliStart = System.currentTimeMillis();
        command = input.next();
        if (command.equals("draw")) {
            long milliEnd = System.currentTimeMillis();
            reactionTime = milliEnd - milliStart;
            hero.setReactionSpeed(reactionTime);
            hero.setHasWon(reactionTime < enemy.getReactionSpeed());
        }
    }
}
