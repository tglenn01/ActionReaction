package persistance;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReadDataTest {
    private static final String TEST_FILE = "./data/testHighScores.txt";
    ReadData testReadData;

    @Test
    void testParseHighScores() {
        try {
            testReadData = new ReadData(TEST_FILE);
            assertEquals(5, testReadData.getSavedHighScores().getHighScore(0));
            assertEquals(16, testReadData.getSavedHighScores().getHighScore(2));
        } catch (ParseException | IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
