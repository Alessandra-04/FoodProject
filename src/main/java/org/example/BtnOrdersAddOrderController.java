package org.example;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class BtnOrdersAddOrderController {

    public void switchToSecondary(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
