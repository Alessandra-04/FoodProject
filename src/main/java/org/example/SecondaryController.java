package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SecondaryController implements Initializable {

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnEmployees;

    @FXML
    private Button btnInventory;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnProducts;

    @FXML
    private Pane pnlTitle;

    @FXML
    private Label lblTitleUnit;

    // grid panes

    @FXML
    private GridPane pnlCustomers;

    @FXML
    private GridPane pnlEmployees;

    @FXML
    private GridPane pnlInventory;

    @FXML
    private GridPane pnlOrders;

    @FXML
    private GridPane pnlOverview;

    @FXML
    private GridPane pnlProducts;

    // BUTTONS

    // Buttons in the panel of Orders
    @FXML
    private Button btnOrdersAddOrder;

    // Buttons in the panel of Inventory
    @FXML
    private Button btnInventoryExpenses, btnInventoryShoppingList, btnInventoryAddItem;

    // Buttons in the panel of Products
    @FXML
    private Button btnProductsRecipe, btnProductsAddProduct;

    // Button in the panel of Customer
    @FXML
    private Button btnCustomerAddCustomer;

    // Button in the panel of Employees
    @FXML
    private Button btnEmployeesAddEmployee;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void handleClinks(javafx.event.ActionEvent event) {
        if (event.getSource() == btnOverview) {
            lblTitleUnit.setText("OVERVIEW");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(159, 231, 245), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlOverview.toFront();

        } else if (event.getSource() == btnOrders) {
            lblTitleUnit.setText("ORDERS");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(157, 255, 232), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlOrders.toFront();

        } else if (event.getSource() == btnInventory) {
            lblTitleUnit.setText("INVENTORY");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(85, 168, 254), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlInventory.toFront();

        } else if (event.getSource() == btnProducts) {
            lblTitleUnit.setText("PRODUCTS");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(85, 168, 254), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlProducts.toFront();

        } else if (event.getSource() == btnCustomers) {
            lblTitleUnit.setText("CUSTOMERS");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(85, 168, 254), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlCustomers.toFront();

        } else if (event.getSource() == btnEmployees) {
            lblTitleUnit.setText("EMPLOYEES");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(85, 168, 254), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlEmployees.toFront();
        }
    }

    public void switchToPrimary(ActionEvent actionEvent) {
    }

    public void handleBtnAddOrder(ActionEvent actionEvent) {
    }
}