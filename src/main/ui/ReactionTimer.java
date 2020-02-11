package ui;

import model.character.Character;
import model.character.PlayableCharacter;

import java.util.Scanner;

import java.sql.Time;

import static java.lang.Thread.sleep;

public class ReactionTimer {
    long reactionTime;

    @SuppressWarnings("checkstyle:LineLength")
    ReactionTimer(PlayableCharacter hero, Character enemy) throws InterruptedException {
        String command = null;
        Scanner input = new Scanner(System.in);

        sleep(5000);

        System.out.println("!");
        long milliStart = System.currentTimeMillis();
        command = input.next();
        if (command.equals("a")) {
            long milliEnd = System.currentTimeMillis();
            reactionTime = milliEnd - milliStart;
            toDecimal(reactionTime);
            hero.setReactionSpeed(reactionTime);
            hero.setHasWon(reactionTime <= enemy.getReactionSpeed());
        }
    }

    private void toDecimal(long reactionTime) {
        this.reactionTime = (this.reactionTime / 1000);
    }
}
