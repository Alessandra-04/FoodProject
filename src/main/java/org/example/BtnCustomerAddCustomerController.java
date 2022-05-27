package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class BtnCustomerAddCustomerController {

    public static TextField csCusId;
    public static TextField csName;
    public static TextField csDescrip;
    public static TextField csContact;
    public static TextField csDateOfPur;
    public static TextField csReview;

    public void switchToSecondary(ActionEvent actionEvent) {
        Boolean exists = false;
        for(NewCustomer f:App.newCustomers){
            if (f.getCustomerIdCs() == (Integer.parseInt(csCusId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){
            App.newCustomers.add(new NewCustomer(Long.parseLong(csCusId.getText()), csName.getText(), csDescrip.getText(), Long.parseLong(csContact.getText()), Integer.parseInt(csDateOfPur.getText()), csReview.getText()));
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
