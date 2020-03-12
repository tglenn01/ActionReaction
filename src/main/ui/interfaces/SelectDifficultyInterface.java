package ui.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import ui.GameUI;
import ui.defaultlayouts.DifficultyButton;

import java.util.ArrayList;
import java.util.List;


public class SelectDifficultyInterface extends AllScenes implements EventHandler<ActionEvent> {
    private static final int MAX_DIFFICULTY = 5;
    private List<DifficultyButton> difficultyList;
    private int selectedDifficulty;

    public SelectDifficultyInterface(GameUI gameUI) {
        super(gameUI);
        selectedDifficulty = 1;
        difficultyList = new ArrayList<>();
        super.initializeGraphics();
    }

    @Override
    protected void initializeRegions() {
        super.createNewLabel("Choose your difficulty");

        for (int i = 1; i <= MAX_DIFFICULTY; i++) {
            DifficultyButton difficultyButton = new DifficultyButton(i, this);
            difficultyList.add(difficultyButton);
        }
        super.createHorizontalList(difficultyList);
    }

    @Override
    public void handle(ActionEvent event) {
        for (DifficultyButton difficultyButton: difficultyList) {
            if (event.getSource() == difficultyButton) {
                selectedDifficulty = difficultyButton.getButtonDifficulty();
                gameUI.startNewDual(selectedDifficulty);
            }
        }
    }
}
