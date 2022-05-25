package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SecondaryController implements Initializable {

    @FXML private Button btnCustomers;
    @FXML private Button btnEmployees;
    @FXML private Button btnInventory;
    @FXML private Button btnLogout;
    @FXML private Button btnOrders;
    @FXML private Button btnOverview;
    @FXML private Button btnProducts;
    @FXML private Pane pnlTitle;
    @FXML private Label lblTitleUnit;

    // grid panes

    @FXML private GridPane pnlCustomers;
    @FXML private GridPane pnlEmployees;
    @FXML private GridPane pnlInventory;
    @FXML private GridPane pnlOrders;
    @FXML private GridPane pnlOverview;
    @FXML private GridPane pnlProducts;

    // BUTTONS

    // Buttons in the panel of Orders
    @FXML private Button btnOrdersAddOrder;

    // Buttons in the panel of Inventory
    @FXML private Button btnInventoryExpenses, btnInventoryShoppingList, btnInventoryAddItem;

    // Buttons in the panel of Products
    @FXML private Button btnProductsRecipe, btnProductsAddProduct;

    // Button in the panel of Customer
    @FXML private Button btnCustomerAddCustomer;

    // Button in the panel of Employees
    @FXML private Button btnEmployeesAddEmployee;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void handleClinks(javafx.event.ActionEvent event) throws FileNotFoundException {
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
    public void switchToPrimary(ActionEvent actionEvent) throws IOException {
        App.setRoot("primary");
    }

    //ORDERS TABLE

    public TextField oProdId;
    public TextField oCusId;
    public TextField oDescrip;
    public TextField oTotPr;
    public TextField oAssEm;
    public TextField oStatus;
    public TextField oDate;

    public TableView ordersTable;
    public TableColumn<NewOrder, String> prodId = new TableColumn<>("Prod. Id");

    // JSON file of Inventory Churros (items)

    public void initialize() {

        loadNewOrders();

        itemId.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("Id"));

        ordersTable.getColumns().add(prodId);
        ordersTable.setItems(App.newOrders);

        churroItemsTable.setRowFactory(rowClick -> {
            TableRow<NewOrder> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    NewOrder clickedRow = row.getItem();
                    oProdId.setText(Long.toString(clickedRow.getProductIdOrder()));
                    oCusId.setText(Long.toString(clickedRow.getCustomerId()));
                    oDescrip.setText(clickedRow.getDescriptionOfOrder());
                    oTotPr.setText(Double.toString(clickedRow.getTotalPrice()));
                    oAssEm.setText(clickedRow.getAssignedEmployee());
                    oStatus.setText(clickedRow.getStatus());
                    oDate.setText(Integer.toString(clickedRow.getDate()));
                }
            });
            return row;
        });
    }

    public void loadNewOrders() {

        Gson gson = new Gson();
        try (Reader reader = new FileReader("newOrderJson.Json")) {
            ArrayList<NewOrder> imports = gson.fromJson(reader, new TypeToken<ArrayList<FoodItem>>() {
            }.getType());
            App.newOrders = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // INVENTORY TABLE

    public TextField cProdId;
    public TextField cName;
    public TextField cDescrip;
    public TextField cStandCost;
    public TextField cStock;
    public TextField cSupplier;
    public TextField cCatg;

    public TableView churroItemsTable;
    public TableColumn<FoodItem, String> itemId = new TableColumn<>("Item Id");

    // JSON file of Inventory Churros (items)

    public void initialize() {

        loadChurroItems();

        itemId.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("Id"));

        churroItemsTable.getColumns().add(itemId);
        churroItemsTable.setItems(App.foodItems);

        churroItemsTable.setRowFactory(rowClick -> {
            TableRow<FoodItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    FoodItem clickedRow = row.getItem();
                    cProdId.setText(Long.toString(clickedRow.getProductId()));
                    cName.setText(clickedRow.getName());
                    cDescrip.setText(clickedRow.getDescription());
                    cStandCost.setText(Double.toString(clickedRow.getStandardCost()));
                    cStock.setText(Integer.toString(clickedRow.getStock()));
                    cSupplier.setText(clickedRow.getSupplier());
                    cCatg.setText(clickedRow.getCategory());
                }
            });
            return row;
        });
    }

    public void loadChurroItems() {

        Gson gson = new Gson();
        try (Reader reader = new FileReader("foodItemsJson.Json")) {
            ArrayList<FoodItem> imports = gson.fromJson(reader, new TypeToken<ArrayList<FoodItem>>() {
            }.getType());
            App.foodItems = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2.2 Expenses

    // 2.3 Shopping List



    // to do: find ways to tell the user to correct the format they used to write (verification)


    // PRODUCTS TABLE


    // CUSTOMERS TABLE


    // EMPLOYEES TABLE



    // Orders Division

    public void handleBtnAddOrder(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnOrdersAddOrder.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add a new Order");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
        initialize();
    }

    // Inventory Division

    public void handleBtnExpenses(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnInventoryExpenses.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Check the Expenses");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void handleBtnShoppingList(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnInventoryShoppingList.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Your Shopping List");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void handleBtnAddItem(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnInventoryAddItem.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add new Item");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
        initialize();

    }

    // Products Division

    public void handleBtnRecipe(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnProductsRecipe.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Accesses the Recipe");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void handleBtnAddProduct(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnProductsRecipe.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add new Product");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    // Customers Division

    public void handleBtnAddCustomer(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnCustomerAddCustomer.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add new Customer");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    // Employees Division

    public void handleBtnAddEmployee(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SecondaryController.class.getResource("btnEmployeesAddEmployee.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add new Employee");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();

    }
}
