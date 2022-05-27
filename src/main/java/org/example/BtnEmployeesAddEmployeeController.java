package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class BtnEmployeesAddEmployeeController {

    public static TextField eId;
    public static TextField eName;
    public static TextField eShift;
    public static TextField eOrdAssign;
    public static TextField eSrtCon;
    public static TextField eFinCon;

    public void switchToSecondary(ActionEvent actionEvent) {
        Boolean exists = false;
        for(NewEmployee f:App.newEmployees){
            if (f.getEmployeeId() == (Integer.parseInt(eId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){
            App.newEmployees.add(new NewEmployee(Long.parseLong(eId.getText()), eName.getText(), eShift.getText(), eOrdAssign.getText(), Integer.parseInt(eSrtCon.getText()), Integer.parseInt(eFinCon.getText())));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("newEmployeeJson.Json")){
            gson.toJson(App.newEmployees);
            System.out.println("Saved.");
        } catch(IOException e){
            e.printStackTrace();
        }
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
