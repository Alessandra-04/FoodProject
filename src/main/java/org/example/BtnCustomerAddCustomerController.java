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

public class BtnCustomerAddCustomerController {

    public TextField csCusId;
    public TextField csName;
    public TextField csContact;
    public DatePicker csDateOfPur;
    public TextField csReview;
    public Button btnSaveAddCustomer;
    public TextArea csDescription;

    public void switchToSecondary(ActionEvent actionEvent) {
        Boolean exists = false;
        for(NewCustomer f:App.newCustomers){
            if (f.getCustomerIdCs() == (Integer.parseInt(csCusId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){
            System.out.println(csDateOfPur.getValue());
            LocalDate localDate = csDateOfPur.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date datePur = Date.from(instant);
            App.newCustomers.add(new NewCustomer(Long.parseLong(csCusId.getText()), csName.getText(), csDescription.getText(), Long.parseLong(csContact.getText()), datePur, csReview.getText()));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("newCustomerJson.Json")){
            gson.toJson(App.newCustomers);
            System.out.println("Saved.");
        } catch(IOException e){
            e.printStackTrace();
        }
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
