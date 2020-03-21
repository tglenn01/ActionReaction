package ui.interfaces;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import model.character.Character;
import model.character.PlayableCharacter;
import ui.Dual;
import ui.GameUI;
import ui.defaultlayouts.DefaultLabel;
import ui.defaultlayouts.DefaultScene;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

import static java.lang.Thread.sleep;

// Sources: http://sub-second.blogspot.com/2012/08/how-to-measure-response-times-in-java.html)

public class ReactionTimerInterface {
    private Dual dual;

    private PlayableCharacter hero;
    private Character enemy;

    private long reactionTime;
    private Scene reactionTimerScene;

    // MODIFIES: hero
    // EFFECTS: win dual if ui inputs the action faster than the enemy's reaction speed
    public ReactionTimerInterface(Dual dual, PlayableCharacter hero, Character enemy) throws InterruptedException {
        this.dual = dual;
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

    // MODIFIES: primaryStage
    // EFFECTS: changes the gui to showcase the fire prompt
    private void setAfterFireScene() {
        Label fireLabel = new DefaultLabel("FIRE!");
        fireLabel.setId("fireLabel");
        fireLabel.getStylesheets().add(DefaultScene.CSS_FILE);
        reactionTimerScene = new Scene(fireLabel, DefaultScene.GAME_WIDTH, DefaultScene.GAME_HEIGHT);
        GameUI.getInstance().getPrimaryStage().setScene(reactionTimerScene);
    }

    // EFFECTS: produces a random number from 3 to 7 seconds
    private int getRandomNumber() {
        int max = 7000; // 7 seconds
        int min = 3000; // 3 second
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    // EFFECTS: plays noise when the user is suppose to fire their weapon
    private void playSound() {
        String path = "data/131660__bertrof__game-sound-correct.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            GameUI.getInstance().startOver();
        }
    }
}
