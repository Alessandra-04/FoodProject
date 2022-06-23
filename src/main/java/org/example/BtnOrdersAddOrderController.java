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

    public TextField oProdId;
    public TextField oCusId;
    public TextField oTotPr;
    public TextArea oDescription;
    public DatePicker oDateOfOrder;
    public TextField oStatus;
    public DatePicker oDueDate;
    public Button btnOrdersAddSave;

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
            System.out.println(oDateOfOrder.getValue());
            LocalDate localDate = oDateOfOrder.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dateOfOrder = Date.from(instant);
            System.out.println(oDueDate.getValue());
            localDate = oDueDate.getValue();
            instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dueDate = Date.from(instant);
            App.newOrders.add(new NewOrder(Long.parseLong(oProdId.getText()), Long.parseLong(oCusId.getText()), Double.parseDouble(oTotPr.getText()), oDescription.getText(), dateOfOrder, oStatus.getText(), dueDate));
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
