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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    public TableView shoppingListTable;

    public TableColumn<ShoppingItem, Long> sLItem = new TableColumn("Item");
    public TableColumn<ShoppingItem, Long> sLAmount = new TableColumn<>("Amount");

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
        int amountOfBakingPowder = App.churrosRecipe.getIngredients().get(1).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfBakingPowder);
        int amountOfSalt = (App.churrosRecipe.getIngredients().get(2).getAmountLeft() / 12) * Integer.parseInt(txtChoice.getValue());
        System.out.println(amountOfSalt);
        int amountOfOil = App.churrosRecipe.getIngredients().get(3).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        int amountOfSugar = App.churrosRecipe.getIngredients().get(4).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        int amountOfCanela = App.churrosRecipe.getIngredients().get(5).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        int amountOfManjar = App.churrosRecipe.getIngredients().get(6).getAmountLeft() / 12 * Integer.parseInt(txtChoice.getValue());
        for (FoodItem I: App.churrosRecipe.getIngredients()){
            for (FoodItem f:App.foodItems) {

                if(f.getName().equals("Canela")){
                    int needed = f.getAmountLeft() - amountOfCanela;
                    App.shoppingItems.add(new ShoppingItem("Canela", needed));
                }
                if(f.getName().equals("Azucar")){
                    int needed f.getAmountLeft() - amountOfSugar;
                    App.shoppingItems.add(new ShoppingItem("Azucar", needed));
                }
                if(f.getName().equals("Manjar")){
                    int needed f.getAmountLeft() - amountOfManjar;
                    App.shoppingItems.add(new ShoppingItem("Manjar", needed));

                }
            }


        }
        for (ShoppingItem s:App.shoppingItems
             ) {
            System.out.println(s.getName() + " " + s.getAmount());
        }
        //


        App.shoppingItems.add(new ShoppingItem())
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
