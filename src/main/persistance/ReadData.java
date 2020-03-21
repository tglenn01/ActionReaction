package persistance;

import model.game.HighScoreList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Citation: https://mkyong.com/java/json-simple-example-read-and-write-json/
// Takes saved high score list and recreates it
public class ReadData {

    // MODIFIES: savedHighScores
    // EFFECTS: takes saved HighScoreList and recreates it
    public ReadData(String account) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(account)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray highScores = (JSONArray) jsonObject.get("highScores");

            for (Object highScore : highScores) {
                HighScoreList.getInstance().addHighScore((Long) highScore);
            }
        }
    }
}
