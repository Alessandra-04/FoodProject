package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.FileWriter;
import java.io.IOException;

public class BtnInventoryAddItemController {

    public TextField cProdId;
    public TextArea cDescrip;
    public TextField cName;
    public TextField cStandCost;
    public TextField cStock;
    public TextField cSupplier;
    public TextField cCatg;
    public Button cSaveItembtn;


    public void switchToSecondary(ActionEvent actionEvent) {
        Boolean exists = false;
        for(FoodItem f:App.foodItems){
            if (f.getProductId() == (Integer.parseInt(cProdId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){
            App.foodItems.add(new FoodItem(Integer.parseInt(cProdId.getText()), cName.getText(), cDescrip.getText(), Integer.parseInt(cStandCost.getText()), Integer.parseInt(cStock.getText()), cSupplier.getText(), cCatg.getText()));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("foodItemsJson.Json")){
            gson.toJson(App.foodItems);
            System.out.println("Saved.");
        } catch(IOException e){
            e.printStackTrace();
        }
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
