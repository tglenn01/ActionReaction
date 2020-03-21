package model.character;

// The user controlled character
public class PlayableCharacter extends Character {
    private static PlayableCharacter hero;

    //EFFECT: The playable character
    private PlayableCharacter() {
        this.name = "Graham The Hero";
        this.victoryLine = this.name + ": Oh no he's dead!";
        this.deathLine = this.name + ": Em.. i... lyyyyyy.. sorry    I, could...n't.. survive";
        this.alive = true;
        this.hasWon = false;
    }

    // EFFECTS: applies singleton principle to allow onyl one playable character at a time
    public static PlayableCharacter getInstance() {
        if (hero == null) {
            hero = new PlayableCharacter();
        }
        return hero;
    }

    // setter
    public void setReactionSpeed(long reactionTime) {
        this.reactionSpeed = reactionTime;
    }

    // EFFECTS: resets the playable character
    public void clearCharacter() {
        hero = new PlayableCharacter();
    }

}


