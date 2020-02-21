package persistance;

import model.game.HighScoreList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
    private static final String ACCOUNTS_FILE = "./data/highScores.txt";

    public SaveData(HighScoreList list) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonList = new JSONArray();
        for (int i = 0; list.getSize() > i; i++) {
            jsonList.add(i, list.getHighScore(i));
        }

        jsonObject.put("highScores", jsonList);

        try (FileWriter file = new FileWriter(ACCOUNTS_FILE)) {
            file.write(jsonList.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
