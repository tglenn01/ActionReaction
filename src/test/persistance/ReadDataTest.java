package persistance;

import model.game.HighScoreList;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReadDataTest {
    ReadData testReadData;
    @Test
    void testParseHighScores() {
        try {
            testReadData = new ReadData();
            assertEquals(5, testReadData.getSaveHighScores().getHighScore(0));
            assertEquals(16, testReadData.getSaveHighScores().getHighScore(2));
        } catch (ParseException | IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
