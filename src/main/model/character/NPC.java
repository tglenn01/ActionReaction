package model.character;
// A character which the user cannot control

public class NPC extends Character {
    protected Double reactionSpeed;
    private static double BASE_REACTION_SPEED = 2.00;

    // EFFECTS: The playable character
    public NPC() {
        this.name = "Enemy";
        this.victoryLine = "You weren't a challenge";
        this.deathLine = "How could they betray me?";
        this.alive = true;
        this.hasWon = false;
        this.reactionSpeed = BASE_REACTION_SPEED;
    }

    public void setReactionSpeed(double selectedDifficulty)  {
        this.reactionSpeed = BASE_REACTION_SPEED / selectedDifficulty;
    }
}
