package model.game;

import java.util.ArrayList;
import java.util.Collections;


// The high score list for which players will store their high scores

public class HighScoreList {
    private ArrayList<Long> scoreList;
    private static final int LIST_MAX_SIZE = 5;
    private static HighScoreList highScoreList;

    // EFFECTS: Constructs new high score list
    private HighScoreList() {
        scoreList = new ArrayList<>();
    }

    public static HighScoreList getInstance() {
        if (highScoreList == null) {
            highScoreList = new HighScoreList();
        }
        return highScoreList;
    }

    // REQUIRES: newScore >= 0
    // MODIFIES: this
    // EFFECTS: adds the new score to the list making sure it stays in order,
    //          assume the list is already in order
    public void addHighScore(long newScore) {
        if (scoreList.isEmpty()) {
            scoreList.add(newScore);
        } else {
            scoreList.add(newScore);
            Collections.sort(scoreList);
            if (scoreList.size() > LIST_MAX_SIZE) {
                scoreList.remove(LIST_MAX_SIZE);
            }
        }
    }

    // getter
    public long getHighScore(int num) {
        return scoreList.get(num);
    }

    // getter
    public int getSize() {
        return this.scoreList.size();
    }

    // getter
    public ArrayList<Long> getScoreList() {
        return scoreList;
    }

    public void clearHighScoreList() {
        scoreList = new ArrayList<>();
    }
}
