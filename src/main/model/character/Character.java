package model.character;

// Set's up the options for the characters in the game
public abstract class Character {
    protected String name;
    protected String victoryLine;
    protected String deathLine;
    protected boolean alive;
    protected boolean hasWon;
    protected long reactionSpeed;

    // REQUIRES: Character is alive
    // MODIFIES: this
    // EFFECTS: The character dies
    public String die() {
        this.alive = false;
        return this.playDeathLine();
    }

    // MODIFIES: this
    // EFFECTS: flags that character has won
    public String win() {
        return this.playVictoryLine();
    }

    // getter
    public String getName() {
        return this.name;
    }

    // getter
    protected String playVictoryLine() {
        return this.victoryLine;
    }

    // getter
    protected String playDeathLine() {
        return this.deathLine;
    }

    // setter
    public abstract void setReactionSpeed(long selectedDifficulty);

    // getter
    public long getReactionSpeed() {
        return this.reactionSpeed;
    }


}
