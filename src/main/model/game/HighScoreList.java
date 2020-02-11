package model.game;

import java.util.ArrayList;


// The high score list for which players will store their high scores

public class HighScoreList {
    public ArrayList<Long> highScoreList;
    protected static final int LIST_MAX_SIZE = 5;

    // EFFECTS: Constructs new high score list
    public HighScoreList() {
        highScoreList = new ArrayList<>();
    }

    // REQUIRES: newScore > 0
    // MODIFIES: this
    // EFFECTS: adds the new score to the list making sure it stays in order,
    //         assume the list is already in order
    public void addHighScore(long newScore) {
        int tally = 0;
        if (highScoreList.isEmpty()) {
            highScoreList.add(newScore);
        } else {
            for (long score : highScoreList) {
                if ((score > newScore) & !highScoreList.contains(newScore)) {
                    highScoreList.add(tally, newScore);
                    if (highScoreList.size() > (LIST_MAX_SIZE - 1)) {
                        highScoreList.remove(LIST_MAX_SIZE);
                    }
                }
                tally++;
            }
        }
    }

    // getter
    public long getHighScore(int num) {
        return this.highScoreList.get(num - 1);
    }
}