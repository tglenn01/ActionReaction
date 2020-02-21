package persistance;
import model.game.HighScoreList;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SaveDataTest {
    private static final String TEST_FILE = "./data/testHighScores.txt";
    private SaveData testSaveData;
    private HighScoreList testHighScoreList;



    @BeforeEach
    void runBefore() {
        testHighScoreList = new HighScoreList();
        testHighScoreList.addHighScore(5);
        testHighScoreList.addHighScore(7);
        testHighScoreList.addHighScore(16);
    }

    @Test
    void testMakeSaveData() throws IOException {
        testSaveData = new SaveData(testHighScoreList, TEST_FILE);

        try {
            ReadData testReadData = new ReadData(TEST_FILE);
            assertEquals(5, testReadData.getSavedHighScores().getHighScore(0));
            assertEquals(16, testReadData.getSavedHighScores().getHighScore(2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
