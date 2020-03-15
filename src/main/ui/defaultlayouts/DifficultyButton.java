package ui.defaultlayouts;

import ui.interfaces.SelectDifficultyInterface;

// the layout and construction of the difficulty buttons
public class DifficultyButton extends DefaultButton {
    private int buttonDifficulty;

    // MODIFIES: this
    // EFFECTS: constructs a new difficulty button and gives a difficulty value
    public DifficultyButton(int difficulty, SelectDifficultyInterface sdl) {
        super(Integer.toString(difficulty), sdl);
        this.buttonDifficulty = difficulty;
    }

    // getter
    public int getButtonDifficulty() {
        return buttonDifficulty;
    }
}
