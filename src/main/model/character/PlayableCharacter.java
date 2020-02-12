package model.character;

// The user controlled character

public class PlayableCharacter extends Character {

    //EFFECT: The playable character
    public PlayableCharacter() {
        this.name = "Graham The Hero";
        this.victoryLine = this.name + ": Oh no he's dead!";
        this.deathLine = this.name + ": Em.. i... lyyyyyy.. sorry    I, could...n't.. survive";
        this.alive = true;
        this.hasWon = false;
    }

    // setter
    public void setReactionSpeed(long reactionTime) {
        this.reactionSpeed = reactionTime;
    }

    // setter
    public void setHasWon(Boolean outcome) {
        this.hasWon = outcome;
    }

    // getter
    public boolean getHasWon() {
        return this.hasWon;
    }


}


