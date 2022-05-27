package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BtnOrdersAddOrderController {

    public static TextField oProdId;
    public static TextField oCusId;
    public static TextArea oDescrip;
    public static TextField oTotPr;
    public static TextField oAssEm;
    public static TextField oStatus;
    public static DatePicker oDate;

    public void switchToSecondary(ActionEvent actionEvent) {
        //This button saves the new object and switches to secondary screen
        Boolean exists = false;
        for(NewOrder f:App.newOrders){
            if (f.getProductIdOrder() == (Integer.parseInt(oProdId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){
            System.out.println(oDate.getValue());
            LocalDate localDate = oDate.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            App.newOrders.add(new NewOrder(Long.parseLong(oProdId.getText()), Long.parseLong(oCusId.getText()), oDescrip.getText(), Double.parseDouble(oTotPr.getText()), oAssEm.getText(), oStatus.getText(), date));
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
