package persistance;

import model.game.HighScoreList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

// Citation https://mkyong.com/java/json-simple-example-read-and-write-json/
// Saves high score list of current session for future use
public class SaveData {

    public SaveData(HighScoreList list, String account) throws IOException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonList = new JSONArray();
        for (int i = 0; list.getSize() > i; i++) {
            jsonList.add(i, list.getHighScore(i));
        }

        jsonObject.put("highScores", jsonList);

        try (FileWriter file = new FileWriter(account)) {
            file.write(jsonObject.toJSONString());
        }
    }
}
