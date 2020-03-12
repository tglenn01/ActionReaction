package ui;

import javafx.application.Application;
import javafx.stage.Stage;

// EFFECTS: start new game with empty high score list
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new GameUI(primaryStage);
    }
}
