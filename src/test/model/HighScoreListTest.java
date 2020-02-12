package model;

import model.game.HighScoreList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreListTest {
    HighScoreList emptyList;
    HighScoreList listTwoLong;
    HighScoreList fullList;
    long longOne;
    long longTwo;
    long longThree;
    long longFour;
    long longFive;
    long longSix;



    @BeforeEach
    private void RunBefore() {
        emptyList = new HighScoreList();

        longOne = 1000;
        longTwo = 2000;
        longThree = 3000;
        longFour = 4000;
        longFive = 5000;
        longSix = 6000;

        listTwoLong = new HighScoreList();
        listTwoLong.addHighScore(longOne);
        listTwoLong.addHighScore(longTwo);

        fullList = new HighScoreList();
        fullList.addHighScore(longOne);
        fullList.addHighScore(longTwo);
        fullList.addHighScore(longThree);
        fullList.addHighScore(longFour);
        fullList.addHighScore(longFive);
    }

    @Test
    public void testSingleHighScore() {
        assertEquals(longTwo, listTwoLong.getHighScore(1));
        assertEquals(longFive, fullList.getHighScore(4));
    }

    @Test
    public void testAddToMany() {
        assertEquals(5, fullList.getSize());
        fullList.addHighScore(longSix);
        assertEquals(5, fullList.getSize());
    }

    @Test
    public void testInOrder() {
        assertEquals(longTwo, listTwoLong.getHighScore(1));
        assertEquals(longFive, fullList.getHighScore(4));

        HighScoreList mixedUpList = new HighScoreList();
        mixedUpList.addHighScore(longFour);
        mixedUpList.addHighScore(longOne);
        mixedUpList.addHighScore(longFive);
        mixedUpList.addHighScore(longThree);
        mixedUpList.addHighScore(longTwo);

        assertEquals(longOne, mixedUpList.getHighScore(0));
        assertEquals(longTwo, mixedUpList.getHighScore(1));
        assertEquals(longThree, mixedUpList.getHighScore(2));
        assertEquals(longFour, mixedUpList.getHighScore(3));
        assertEquals(longFive, mixedUpList.getHighScore(4));

    }

}