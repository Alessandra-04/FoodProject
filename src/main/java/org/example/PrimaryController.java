package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;

public class PrimaryController {
    public void switchToSecondary(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}
