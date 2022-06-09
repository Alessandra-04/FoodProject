package org.example;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;


public class BtnInventoryExpensesController {
    public Button btnScanReciept;
    public Button btnSave;
    public Button btnPrint;
    public Button btnCompleted;

    public void goInventory(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    }

