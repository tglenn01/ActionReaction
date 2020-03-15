package ui;

import javafx.application.Application;
import javafx.stage.Stage;

// launches the primary Stage which is then passed on into a new GameUI
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new GameUI(primaryStage);
    }
}
