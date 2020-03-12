package ui.defaultlayouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class DefaultButton extends Button {

    public DefaultButton(String text, EventHandler<ActionEvent> setHandleTo) {
        this.setText(text);
        this.setOnAction(setHandleTo);
        this.setAlignment(Pos.CENTER);
        initializeGraphics();
    }

    private void initializeGraphics() {
        this.setStyle("-fx-background-color: peachpuff; "
                + "-fx-text-fill: black; "
                + "-fx-font: 16px 'impact'; "
                + "-fx-border-style: solid; "
                + "-fx-border-color: black;");
    }
}
