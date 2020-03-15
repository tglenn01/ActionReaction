package ui.defaultlayouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

//  The average layout and handling of all buttons in the program
public class DefaultButton extends Button {

    // MODIFIES: this
    // EFFECTS: creates a new button with given text and sets handle to given event handler
    public DefaultButton(String text, EventHandler<ActionEvent> setHandleTo) {
        this.setText(text);
        this.setOnAction(setHandleTo);
        this.setAlignment(Pos.CENTER);
    }
}
