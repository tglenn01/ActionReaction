package persistance;

import model.game.HighScoreList;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PersistingTest {
    private static final String TEST_FILE = "./data/testHighScores.txt";

    @BeforeEach
    void runBefore() {
        HighScoreList.getInstance().addHighScore(1);
        HighScoreList.getInstance().addHighScore(22);
        HighScoreList.getInstance().addHighScore(333);
    }

    @Test
    void testSaveData() throws IOException {
        new SaveData(TEST_FILE);
        HighScoreList.getInstance().clearHighScoreList();

        try {
            new ReadData(TEST_FILE);
            assertEquals(1, HighScoreList.getInstance().getHighScore(0));
            assertEquals(333, HighScoreList.getInstance().getHighScore(2));
        } catch (ParseException e) {
            fail("Exception not expected");
        }
    }
}
