package model.game;

import java.util.ArrayList;


// The high score list for which players will store their high scores

public class HighScoreList {
    public ArrayList<Double> highScoreList;
    protected static final int LIST_MAX_SIZE = 5;

    // EFFECTS: Constructs new high score list
    public HighScoreList() {
        highScoreList = new ArrayList<>();
    }

    // REQUIRES: newScore > 0
    // MODIFIES: this
    // EFFECTS: adds the new score to the list making sure it stays in order,
    //         assume the list is already in order
    public void addHighScore(Double newScore) {
        if (highScoreList.isEmpty()) {
            highScoreList.add(newScore);
        } else {
            int currentDigit = 0;
            for (double hs: highScoreList) {
                if (hs > newScore & !highScoreList.contains(newScore)) {
                    highScoreList.add(currentDigit, newScore);
                    if (highScoreList.size() > 5) {
                        highScoreList.remove(6);
                    }
                }
                currentDigit++;
            }
        }
    }

    // getter
    public Double getHighScore(int num) {
        return this.highScoreList.get(num);
    }
}
