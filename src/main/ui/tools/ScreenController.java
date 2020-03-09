package ui.tools;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import ui.interfaces.SelectDifficultyInterface;

import java.util.HashMap;

public class ScreenController {
    private HashMap<String, Region> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    public void addScreen(String name, Region region) {
        screenMap.put(name, region);
    }

    protected void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        main.setRoot(screenMap.get(name));
        main.s
    }
}
