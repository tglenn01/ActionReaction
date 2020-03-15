package ui.defaultlayouts;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

//  The average layout and handling of all label in the program
public class DefaultLabel extends Label {

    // MODIFIES: this
    // EFFECTS: constructs a label with given text
    public DefaultLabel(String text) {
        this.setText(text);
        this.setAlignment(Pos.CENTER);
    }
}
