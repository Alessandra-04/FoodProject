package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BtnInventoryShoppingListController {

    public Button btnPrint;
    public Button btnScanReceipt;
    public Button btnCompleted;
    public Button btnSave;

    public void handleScanReceipt (ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                BtnInventoryShoppingListController.class.getResource("btnScanReceipt.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Scan your receipt");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();

    }

    public void goInventory(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
