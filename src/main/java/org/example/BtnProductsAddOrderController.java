package org.example;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class BtnProductsAddOrderController {

    public void switchToSecondary(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
