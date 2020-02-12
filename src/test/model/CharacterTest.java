package model;

import model.character.Character;
import model.character.NPC;
import model.character.PlayableCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.character.NPC.BASE_REACTION_SPEED;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    Character hero;
    Character npc;
    PlayableCharacter playableCharacter;

    @BeforeEach
    public void runBefore() {
        hero = new PlayableCharacter();
        npc = new NPC();
        playableCharacter = new PlayableCharacter();
    }

    @Test
    public void testGetVictoryLine() {
        assertEquals(hero.victoryLine, hero.getVictoryLine());
    }

    @Test
    public void testWin() {
        assertEquals(hero.victoryLine, hero.win());
    }

    @Test
    public void testDie() {
        assertTrue(hero.alive);
        assertEquals(hero.deathLine, hero.die());
        hero.die();
        assertFalse(hero.alive);
    }

    @Test
    public void testSetReactionSpeed() {
        long reactionTime = 5;
        npc.setReactionSpeed(reactionTime);
        hero.setReactionSpeed(reactionTime);
        assertEquals((BASE_REACTION_SPEED / reactionTime), npc.getReactionSpeed());
        assertEquals(reactionTime, hero.getReactionSpeed());
    }

    @Test
    public void testGettersAndSetter() {
        assertEquals(hero.name, hero.getName());
        assertEquals(playableCharacter.hasWon, playableCharacter.getHasWon());
        assertEquals(hero.deathLine, hero.getDeathLine());
    }

    @Test
    public void testHasWon() {
        playableCharacter.setHasWon(false);
        assertFalse(playableCharacter.getHasWon());
        playableCharacter.setHasWon(true);
        assertTrue(playableCharacter.getHasWon());
    }
}
