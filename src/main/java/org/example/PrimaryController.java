package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Staff.java.Staff;
import Staff.json.Staff;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");

        Gson gson = new Gson();

        Staff obj = new Staff();

        // 1. Java object to JSON file
        gson.toJson(obj, new FileWriter("C:\\projects\\staff.json"));

        // 2. Java object to JSON string
        String jsonInString = gson.toJson(obj);

    }
}
