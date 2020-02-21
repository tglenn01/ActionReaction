package persistance;

import model.game.HighScoreList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;


public class ReadData {
    private static final String ACCOUNTS_FILE = "./data/highScores.txt";
    HighScoreList saveHighScores;

    public ReadData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        saveHighScores = new HighScoreList();

        try (Reader reader = new FileReader(ACCOUNTS_FILE)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray highScores = (JSONArray) jsonObject.get("highScores");

            for (Object highScore : highScores) {
                saveHighScores.addHighScore((Long) highScore);
            }
        }
    }

    public HighScoreList getSaveHighScores() {
        return saveHighScores;
    }
}
