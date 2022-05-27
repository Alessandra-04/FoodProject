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

public class BtnOrdersAddOrderController {

    public static TextField oProdId;
    public static TextField oCusId;
    public static TextField oDescrip;
    public static TextField oTotPr;
    public static TextField oAssEm;
    public static TextField oStatus;
    public static TextField oDate;

    public void switchToSecondary(ActionEvent actionEvent) {

        Boolean exists = false;
        for(NewOrder f:App.newOrders){
            if (f.getProductIdOrder() == (Integer.parseInt(oProdId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){
            App.newOrders.add(new NewOrder(Long.parseLong(oProdId.getText()), Long.parseLong(oCusId.getText()), oDescrip.getText(), Double.parseDouble(oTotPr.getText()), oAssEm.getText(), oStatus.getText(), Integer.parseInt(oDate.getText())));
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
