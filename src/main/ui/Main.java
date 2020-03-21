package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.interfaces.MainScreenInterface;


// launches the primary Stage which is then passed on into a new GameUI
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GameUI.getInstance().setPrimaryStage(primaryStage);
        primaryStage.setTitle("Action Reaction!");
        new MainScreenInterface();
        primaryStage.show();
    }
}
