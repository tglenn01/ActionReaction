package model;

import model.game.HighScoreList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreListTest {
    HighScoreList fullList;
    long longOne;
    long longTwo;
    long longThree;
    long longFour;
    long longFive;
    long longSix;



    @BeforeEach
    private void runBefore() {
        longOne = 1000;
        longTwo = 2000;
        longThree = 3000;
        longFour = 4000;
        longFive = 5000;
        longSix = 6000;

        fullList = HighScoreList.getInstance();
        fullList.clearHighScoreList();
        fullList.addHighScore(longOne);
        fullList.addHighScore(longTwo);
        fullList.addHighScore(longThree);
        fullList.addHighScore(longFour);
        fullList.addHighScore(longFive);
    }

    @Test
    public void testSingleHighScore() {
        assertEquals(longFive, fullList.getHighScore(4));
    }

    @Test
    public void testAddToMany() {
        assertEquals(5, fullList.getSize());
        fullList.addHighScore(longSix);
        assertEquals(5, fullList.getSize());
    }

    @Test
    void testClearList() {
        assertFalse(fullList.getScoreList().isEmpty());
        fullList.clearHighScoreList();
        assertTrue(fullList.getScoreList().isEmpty());
    }
}