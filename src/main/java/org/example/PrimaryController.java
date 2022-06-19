package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable {

    public recipe churrosRecipe = new recipe();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        recipeItem water = new recipeItem();

        water.ingredient = "water";
        water.quantity = 250;
        water.unitOfMeasurement = "ml";

        // how to use class constructors

        churrosRecipe.recipeItems.add(water);

        System.out.println(churrosRecipe.recipeItems.get(0).unitOfMeasurement);
    }

    public void switchToSecondary(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}
