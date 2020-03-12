package ui.defaultlayouts;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class DefaultLabel extends Label {

    public DefaultLabel(String text) {
        this.setText(text);
        this.setAlignment(Pos.CENTER);
        initializeGraphics();
    }

    private void initializeGraphics() {
        this.setStyle("-fx-text-fill: black;"
                        + "-fx-font: 32px 'impact';");
    }
}
