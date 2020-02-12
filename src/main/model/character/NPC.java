package model.character;

// A character which the user cannot control

public class NPC extends Character {
    private static long BASE_REACTION_SPEED = 2000; // in ms

    // EFFECTS: Constructs the non playable character
    public NPC() {
        this.name = "Enemy";
        this.victoryLine = this.name + ": You weren't a challenge";
        this.deathLine = this.name + ": How could they betray me?";
        this.alive = true;
        this.hasWon = false;
        this.reactionSpeed = BASE_REACTION_SPEED;
    }

    // setter
    public void setReactionSpeed(long selectedDifficulty)  {
        this.reactionSpeed = BASE_REACTION_SPEED / selectedDifficulty;
    }
}
