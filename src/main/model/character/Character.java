package model.character;

// Set's up the options for the characters in the game
public abstract class Character {
    protected String name;
    protected String victoryLine;
    protected String deathLine;
    protected boolean alive;
    protected boolean hasWon;


    // EFFECTS: character puts out a line of dialogue
    protected abstract void talk(Character character);

    // REQUIRES: character and opponent are alive
    // MODIFIES: opponent and character
    // EFFECTS: Causes opponent to die and character to win
    protected abstract void shoot(Character character, Character opponent);

    // REQUIRES: Character is alive
    // MODIFIES: character
    // EFFECTS: The character dies
    protected void die(Character character) {
        System.out.println(character.playDeathLine());
        character.alive = false;
    }

    // MODIFIES: character
    // EFFECTS: flags that character has won
    protected void win(Character character) {
        character.playVictoryLine();
        System.out.println("You won!!");
    }

    // MODIFIES: character
    // EFFECTS: flags that the character has lost
    protected abstract void lose(Character character);

    // getter
    protected boolean didWin(Character character) {
        return hasWon;
    }

    // setter
    protected void setName(String newName) {
        this.name = newName;
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
    protected String playDeathLine() {
        System.out.println(this.deathLine);
    }

    public abstract void setReactionSpeed(double selectedDifficulty);

    public abstract Double getReactionSpeed();

}
