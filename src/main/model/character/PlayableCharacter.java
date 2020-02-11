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

    public void setReactionSpeed(long reactionTime) {
        this.reactionSpeed = reactionTime;
    }

    @Override
    public void win() {
        super.win();
        System.out.println(this.name + ": Time for the next challenge");

    }

    public boolean hasShot() {
        return false;
    }


    //getter
    public boolean getHasWon() {
        return this.hasWon;
    }

    public void setHasWon(Boolean outcome) {
        this.hasWon = outcome;
    }

}


