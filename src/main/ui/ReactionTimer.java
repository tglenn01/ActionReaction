package ui;

import model.character.Character;
import model.character.PlayableCharacter;

import java.util.Scanner;
import static java.lang.Thread.sleep;

// (Citation: http://sub-second.blogspot.com/2012/08/how-to-measure-response-times-in-java.html)

public class ReactionTimer {
    long reactionTime;

    // MODIFIES: hero
    // EFFECTS: win dual if ui inputs the action faster than the enemy's reaction speed
    ReactionTimer(PlayableCharacter hero, Character enemy) throws InterruptedException {
        String command;
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
