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

public class BtnEmployeesAddEmployeeController {

    public TextField eId;
    public TextField eName;
    public TextField eShift;
    public TextField eOrdAssign;
    public DatePicker eSrtCon;
    public DatePicker eFinCon;
    public Button btnNewEmployeeSave;

    public void switchToSecondary(ActionEvent actionEvent) {
        boolean exists = false;
        for(NewEmployee f:App.newEmployees){
            if (f.getEmployeeId() == (Integer.parseInt(eId.getText()))) {
                exists = true;
                System.out.println("already exists.");
            }
        }
        if(exists == false){
            System.out.println(eSrtCon.getValue());
            LocalDate localDate = eSrtCon.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dateSrt = Date.from(instant);
            System.out.println(eFinCon.getValue());
            localDate = eFinCon.getValue();
            instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date dateFin = Date.from(instant);
            App.newEmployees.add(new NewEmployee(Long.parseLong(eId.getText()), eName.getText(), eShift.getText(), eOrdAssign.getText(), dateSrt, dateFin));
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
