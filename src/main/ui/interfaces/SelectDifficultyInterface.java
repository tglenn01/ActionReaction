package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import ui.GameUI;
import ui.defaultlayouts.DefaultScene;
import ui.defaultlayouts.DifficultyButton;

import java.util.ArrayList;
import java.util.List;

// The interface where the user selects the difficulty for their dual
public class SelectDifficultyInterface extends DefaultScene implements EventHandler<ActionEvent> {
    private static final int MAX_DIFFICULTY = 5;
    private List<DifficultyButton> difficultyList;
    private int selectedDifficulty;

    // MODIFIES: this
    // EFFECTS: constructs a new DefaultScene, and initialized difficulty list and sets selectedDifficulty to default 1
    public SelectDifficultyInterface(GameUI gameUI) {
        super(gameUI);
        selectedDifficulty = 1;
        difficultyList = new ArrayList<>();
        super.initializeGraphics();
    }

    @Override
    // EFFECTS: creates a difficulty button for each difficulty up to MAX_DIFFICULTY, also makes an instruction label
    protected void initializeRegions() {
        super.createNewLabel("Choose your difficulty");

        for (int i = 1; i <= MAX_DIFFICULTY; i++) {
            DifficultyButton difficultyButton = new DifficultyButton(i, this);
            difficultyList.add(difficultyButton);
        }
        super.createHorizontalList(difficultyList);
    }

    @Override
    // EFFECTS: on button press runs startNewDual in GameUI with the difficulty of the selected button
    public void handle(ActionEvent event) {
        for (DifficultyButton difficultyButton: difficultyList) {
            if (event.getSource() == difficultyButton) {
                selectedDifficulty = difficultyButton.getButtonDifficulty();
                gameUI.startNewDual(selectedDifficulty);
            }
        }
    }
}
