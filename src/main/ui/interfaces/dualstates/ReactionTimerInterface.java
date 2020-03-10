package ui.interfaces.dualstates;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import model.character.Character;
import model.character.PlayableCharacter;
import ui.Dual;
import ui.GameUI;

import static java.lang.Thread.sleep;

// (Citation: http://sub-second.blogspot.com/2012/08/how-to-measure-response-times-in-java.html)

public class ReactionTimerInterface {
    private long reactionTime;
    private Scene reactionTimerScene;
    private PlayableCharacter hero;
    private Character enemy;
    private GameUI gameUI;
    private Dual dual;

    // MODIFIES: hero
    // EFFECTS: win dual if ui inputs the action faster than the enemy's reaction speed
    public ReactionTimerInterface(GameUI gameUI, Dual dual,
                                  PlayableCharacter hero, Character enemy) throws InterruptedException {
        this.dual = dual;
        this.gameUI = gameUI;
        this.hero = hero;
        this.enemy = enemy;
        startTimer();
    }

    private void startTimer() throws InterruptedException {
        sleep(5000);

        setAfterFireScene();
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
        Label fireLabel = new Label("FIRE!");
        fireLabel.setAlignment(Pos.CENTER);
        reactionTimerScene = new Scene(fireLabel, GameUI.GAME_WIDTH, GameUI.GAME_HEIGHT);
        gameUI.primaryStage.setScene(reactionTimerScene);
    }
}
