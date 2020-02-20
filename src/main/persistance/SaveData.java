package persistance;

import model.game.HighScoreList;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class SaveData {
    public SaveData(HighScoreList list) throws IOException {
        JSONArray jsonlist = new JSONArray();
        for (int i = 0; list.getSize() >= i; i++) {
            jsonlist.add(i, list.getHighScore(i));
        }
        ArrayWritter out =

        ;
    }
}
