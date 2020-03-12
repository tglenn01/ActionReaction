package ui.defaultlayouts;

import ui.interfaces.SelectDifficultyInterface;

public class DifficultyButton extends DefaultButton {
    private int buttonDifficulty;

    public DifficultyButton(int difficulty, SelectDifficultyInterface sdl) {
        super(Integer.toString(difficulty), sdl);
        this.buttonDifficulty = difficulty;
    }

    public int getButtonDifficulty() {
        return buttonDifficulty;
    }
}
