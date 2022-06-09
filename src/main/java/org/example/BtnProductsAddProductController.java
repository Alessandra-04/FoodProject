package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BtnProductsAddProductController {

    public TextField pProdId;
    public TextField pCategory;
    public DatePicker pDateMade;
    public DatePicker pExpDate;
    public TextField pAmtProd;
    public Button pBtnSave;


    public void switchToSecondary(ActionEvent actionEvent) {
        //This button saves the new object and switches to secondary screen
        Boolean exists = false;
        for(AddProduct f:App.addProducts){
            if (f.getProductProd() == (Long.parseLong(pProdId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){

            System.out.println(pDateMade.getValue());
            LocalDate localDate = pDateMade.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dateMade = Date.from(instant);

            System.out.println(pExpDate.getValue());
            localDate = pExpDate.getValue();
            instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dateExp = Date.from(instant);

            App.addProducts.add(new AddProduct(Long.parseLong(pProdId.getText()), pCategory.getText(), dateMade, dateExp, (Integer.parseInt(pAmtProd.getText()));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("newOrderJson.Json")){
            gson.toJson(App.newOrders);
            System.out.println("Saved.");
        } catch(IOException e){
            e.printStackTrace();
        }

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
