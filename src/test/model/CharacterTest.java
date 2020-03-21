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

    @BeforeEach
    void runBefore() {
        hero = PlayableCharacter.getInstance();
        npc = new NPC();
    }

    @Test
    void testWin() {
        assertEquals(hero.getVictoryLine(), hero.win());
        assertEquals("Graham The Hero", hero.getName());
    }

    @Test
    void testDie() {
        assertTrue(hero.getIsAlive());
        assertEquals(hero.getDeathLine(), hero.die());
        hero.die();
        assertFalse(hero.getIsAlive());
    }

    @Test
    void testSetReactionSpeed() {
        long reactionTime = 5;
        npc.setReactionSpeed(reactionTime);
        hero.setReactionSpeed(reactionTime);
        assertEquals((BASE_REACTION_SPEED / reactionTime), npc.getReactionSpeed());
        assertEquals(reactionTime, hero.getReactionSpeed());
    }

    @Test
    void testHasWon() {
        hero.setHasWon(false);
        assertFalse(hero.getHasWon());
        hero.setHasWon(true);
        assertTrue(hero.getHasWon());
    }

    @Test
    void testClearCharacter() {
        hero.clearCharacter();
        npc.clearCharacter();
    }
}
