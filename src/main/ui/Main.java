package ui;

import model.game.HighScoreList;

public class Main {
    public static void main(String[] args) {
        new GameUI(new HighScoreList());
    }
}
