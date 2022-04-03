package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SecondaryController {

    public Button btnProducts;
    public HBox hboxtitle;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void showProductsDashboard() throws IOException {

        if (hboxtitle.isVisible()) {
            hboxtitle.setVisible(false);
        }else{
            hboxtitle.setVisible(true);
        }
    }


}