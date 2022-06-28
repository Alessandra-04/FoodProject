package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static ObservableList<FoodItem> foodItems = FXCollections.observableArrayList();
    public static ObservableList<NewOrder> newOrders = FXCollections.observableArrayList();
    public static ObservableList<AddProduct> addProducts = FXCollections.observableArrayList();
    public static ObservableList<NewCustomer> newCustomers = FXCollections.observableArrayList();
    public static Recipe churrosRecipe;

    @Override
    public void start(Stage stage) throws IOException {
        /** Churros Recipe **/
      /*  Recipe:

        150 g flour
        1 tsp baking powder
        Pinch of salt
        1 tbsp vegetable, canola or olive oil (not extra virgin olive oil)
        250 ml boiling water
        500 ml+ vegetable or canola oil , for frying
       */

        //ArrayList<recipeItem> recipeItems;
        ArrayList<FoodItem> ingredients = new ArrayList<>();

        FoodItem flour = new FoodItem(123421213,"Flour", 8.90, 1000);
        flour.setAmountLeft(150);
        ingredients.add(flour);

        String method = "This is how I make a churro \n is a new line.";
        int portions = 12;
        int minutes = 15;
        churrosRecipe = new Recipe(ingredients,method,portions,minutes);
        /**End of churros Recipe**/
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();





    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}