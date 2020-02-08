package model.character;
// The user controlled character

public class PlayableCharacter extends Character {

    //EFFECT: The playable character
    public PlayableCharacter() {
        this.name = "Graham";
        this.victoryLine = "Thank God";
        this.deathLine = "Em.. i... lyyyyyy..";
        this.alive = true;
        this.hasWon = false;
    }


    @Override
    protected void talk(Character character) {

    }

    @Override
    protected void shoot(Character character, Character opponent) {

    }

    @Override
    protected void lose(Character character) {

    }

    @Override
    protected void setReactionSpeed(double selectedDifficulty) {

    }
}
}

