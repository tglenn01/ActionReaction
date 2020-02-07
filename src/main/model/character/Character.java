package model.character;

public interface Character {
    boolean alive = true;
    boolean hasWon = false;

    //EFFECTS: Character puts out a line of dialogue
    void talk(Character character);

    //REQUIRES: Character and Opponent are alive
    //MODIFIES: Opponent and Character
    //EFFECTS: Causes opponent to die and character to win
    void shoot(Character character, Character opponent);

    //REQUIRES: Character is alive
    //
    void die(Character character);

    void win(Character character);

    void lose(Character character);

    boolean didWin(Character character);
}
