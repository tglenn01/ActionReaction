package ui.tools;

import javafx.scene.control.Button;
import ui.interfaces.SelectDifficultyInterface;

public class DifficultyButton extends Button {
    private int buttonDifficulty;

    public DifficultyButton(int difficulty, SelectDifficultyInterface sdl) {
        this.buttonDifficulty = difficulty;
        setText(Integer.toString(difficulty));
        setOnAction(sdl);
    }

    public int getButtonDifficulty() {
        return buttonDifficulty;
    }
}
