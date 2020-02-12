package model.character;

// The user controlled character

public class PlayableCharacter extends Character {

    //EFFECT: The playable character
    public PlayableCharacter() {
        this.name = "Graham";
        this.victoryLine = this.name + ": Thank God";
        this.deathLine = this.name + ": Em.. i... lyyyyyy..";
        this.alive = true;
        this.hasWon = false;
    }

    // setter
    public void setReactionSpeed(long reactionTime) {
        this.reactionSpeed = reactionTime;
    }

    // getter
    public boolean getHasWon() {
        return this.hasWon;
    }

    // setter
    public void setHasWon(Boolean outcome) {
        this.hasWon = outcome;
    }

}


