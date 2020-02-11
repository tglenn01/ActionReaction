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
    // MODIFIES: character
    // EFFECTS: The character dies
    public void die() {
        this.playDeathLine();
        this.alive = false;
    }

    // MODIFIES: character
    // EFFECTS: flags that character has won
    public void win() {
        this.playVictoryLine();
    }

    // getter
    public String getName() {
        return this.name;
    }

    // getter
    protected void playVictoryLine() {
        System.out.println(this.victoryLine);
    }

    // getter
    protected void playDeathLine() {
        System.out.println(this.deathLine);
    }

    public abstract void setReactionSpeed(long selectedDifficulty);

    // getter
    public long getReactionSpeed() {
        return this.reactionSpeed;
    }


}
