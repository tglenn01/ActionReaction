package model.character;

// Set's up the options for the characters in the game
public abstract class Character {
    public String name;
    public String victoryLine;
    public String deathLine;
    public boolean alive;
    public boolean hasWon;
    protected long reactionSpeed;

    // REQUIRES: Character is alive
    // MODIFIES: this
    // EFFECTS: The character dies
    public String die() {
        this.alive = false;
        return this.getDeathLine();
    }

    // EFFECTS: flags that character has won
    public String win() {
        return this.getVictoryLine();
    }

    // setter
    public abstract void setReactionSpeed(long reactionTime);

    // getter
    public String getName() {
        return this.name;
    }

    // getter
    public String getVictoryLine() {
        return this.victoryLine;
    }

    // getter
    public String getDeathLine() {
        return this.deathLine;
    }

    // getter
    public long getReactionSpeed() {
        return this.reactionSpeed;
    }


}
