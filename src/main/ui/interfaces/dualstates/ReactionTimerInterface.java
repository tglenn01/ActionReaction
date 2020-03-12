package ui.interfaces.dualstates;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.character.Character;
import model.character.PlayableCharacter;
import ui.Dual;
import ui.GameUI;
import ui.defaultlayouts.DefaultLabel;
import ui.interfaces.AllScenes;

import java.io.File;
import java.lang.Math;

import static java.lang.Thread.sleep;

// Sources: http://sub-second.blogspot.com/2012/08/how-to-measure-response-times-in-java.html)

public class ReactionTimerInterface {
    private GameUI gameUI;
    private Dual dual;

    private PlayableCharacter hero;
    private Character enemy;

    private long reactionTime;
    private Scene reactionTimerScene;

    // MODIFIES: hero
    // EFFECTS: win dual if ui inputs the action faster than the enemy's reaction speed
    public ReactionTimerInterface(GameUI gameUI, Dual dual,
                                  PlayableCharacter hero, Character enemy) throws InterruptedException {
        this.dual = dual;
        this.gameUI = gameUI;
        this.hero = hero;
        this.enemy = enemy;
        run();
    }

    private void run() throws InterruptedException {
        startAnticipationTimer();
        startReactionTimer();
    }

    private void startAnticipationTimer() throws InterruptedException {
        sleep(getRandomNumber());
    }

    private void startReactionTimer() {
        setAfterFireScene();
        playSound();
        long milliStart = System.currentTimeMillis();
        reactionTimerScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                long milliEnd = System.currentTimeMillis();
                reactionTime = milliEnd - milliStart;
                hero.setReactionSpeed(reactionTime);
                hero.setHasWon(reactionTime < enemy.getReactionSpeed());
            } else {
                hero.setHasWon(false);
            }
            dual.afterDual();
        });
    }

    private void setAfterFireScene() {
        Label fireLabel = new DefaultLabel("FIRE!");
        reactionTimerScene = new Scene(fireLabel, AllScenes.GAME_WIDTH, AllScenes.GAME_HEIGHT);
        gameUI.primaryStage.setScene(reactionTimerScene);
    }

    private int getRandomNumber() {
        int max = 5000; // 5 seconds
        int min = 1000; // 1 second
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    private void playSound() {
        System.out.println("INSERT SOUND HERE");
    }


}
