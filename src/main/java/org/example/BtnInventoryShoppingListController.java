package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BtnInventoryShoppingListController implements Initializable {

    public Button btnPrint;
    public Button btnScanReceipt;
    public Button btnCompleted;
    public Button btnSave;

    @FXML
    public ChoiceBox<String> txtChoice;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        String[] options = {"6","12","24"};
        txtChoice.getItems().setAll(options);
    }


    public void handleScanReceipt(ActionEvent actionEvent) throws IOException {
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
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void choiceSelected(ActionEvent actionEvent) {
        System.out.println("Choice selected!");

        int amountOfFlour = App.churrosRecipe.getIngredients().get(0).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue()); //flour...
        System.out.println(amountOfFlour);
        //water, sugar, etc
        int amountOfSalt = (App.churrosRecipe.getIngredients().get(0).getAmountLeft() / 12) * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfSalt);
        int amountOfBakingPowder = App.churrosRecipe.getIngredients().get(0).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfBakingPowder);
        int amountOfOil = App.churrosRecipe.getIngredients().get(0).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfOil);
        int amountOfWater = App.churrosRecipe.getIngredients().get(0).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfWater);
        int amountOfSugar = App.churrosRecipe.getIngredients().get(0).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfSugar);
        int amountOfCinnamon = App.churrosRecipe.getIngredients().get(0).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfCinnamon);

        /*
        150 g flour
        1 tsp baking powder
        Pinch of salt
        1 tbsp vegetable, canola or olive oil (not extra virgin olive oil)
        250 ml boiling water
        500 ml+ vegetable or canola oil , for frying
                */
    }
}
