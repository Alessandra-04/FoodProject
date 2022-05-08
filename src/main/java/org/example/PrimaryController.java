package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Staff.java.Staff;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController {
    public void switchToSecondary(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}
