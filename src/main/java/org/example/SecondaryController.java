package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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

    public static TextField oProdId;
    public static TextField oCusId;
    public static TextField oDescrip;
    public static TextField oTotPr;
    public static TextField oAssEm;
    public static TextField oStatus;
    public static TextField oDate;
    public static TableView ordersTable;
    public static TableColumn<NewOrder, String> orProductIds = new TableColumn<>("Prod. Ids");
    public static TableColumn<NewOrder, String> orCusId = new TableColumn<>("Customer Id");
    public static TableColumn<NewOrder, String> orDescription = new TableColumn<>("Description");
    public static TableColumn<NewOrder, String> orTotalPrice = new TableColumn<>("Total Price");
    public static TableColumn<NewOrder, String> orAssignedEmp = new TableColumn<>("Assign. Employee");
    public static TableColumn<NewOrder, String> orStatus = new TableColumn<>("Status");
    public static TableColumn<NewOrder, String> orDate = new TableColumn<>("Date");


    // INVENTORY TABLE (example)

    // 1#
    public static TextField cProdId;
    public static TextField cName;
    public static TextField cDescrip;
    public static TextField cStandCost;
    public static TextField cStock;
    public static TextField cSupplier;
    public static TextField cCatg;
    public static TableView churroItemsTable;
    public static TableColumn<FoodItem, String> itemId = new TableColumn<>("Item. Id");
    public static TableColumn<FoodItem, String> itemName = new TableColumn<>("Name");
    public static TableColumn<FoodItem, String> itemDescrip = new TableColumn<>("Description");
    public static TableColumn<FoodItem, String> itemStnCost = new TableColumn<>("Standard Cost");
    public static TableColumn<FoodItem, String> itemStock = new TableColumn<>("Stock");
    public static TableColumn<FoodItem, String> itemSupp = new TableColumn<>("Supplier");
    public static TableColumn<FoodItem, String> itemCat = new TableColumn<>("Category");

    //PRODUCTS

    //CUSTOMERS
    public static TextField csCusId;
    public static TextField csName;
    public static TextField csDescrip;
    public static TextField csContact;
    public static TextField csDateOfPur;
    public static TextField csReview;
    public static TableView customerTable;
    public static TableColumn<NewCustomer, String> cusId = new TableColumn<>("Customer. Id");
    public static TableColumn<NewCustomer, String> cusName = new TableColumn<>("Name");
    public static TableColumn<NewCustomer, String> cusDescription = new TableColumn<>("Description");
    public static TableColumn<NewCustomer, String> cusContact = new TableColumn<>("Contact");
    public static TableColumn<NewCustomer, String> cusDateOfPur = new TableColumn<>("Date of Purchase");
    public static TableColumn<NewCustomer, String> cusReview = new TableColumn<>("Customer Review");

    // EMPLOYEES
    public static TextField eId;
    public static TextField eName;
    public static TextField eShift;
    public static TextField eOrdAssign;
    public static TextField eSrtCon;
    public static TextField eFinCon;
    public static TableView employeeTable;
    public static TableColumn<NewEmployee, String> empId = new TableColumn<>("Emp. Id");
    public static TableColumn<NewEmployee, String> empName = new TableColumn<>("Name");
    public static TableColumn<NewEmployee, String> empShift = new TableColumn<>("Shift");
    public static TableColumn<NewEmployee, String> empOrdAssigned = new TableColumn<>("Order Assigned");
    public static TableColumn<NewEmployee, String> empSrtContract = new TableColumn<>("Start Contract");
    public static TableColumn<NewEmployee, String> empFinContract = new TableColumn<>("Finish Contract");

    // ORDERS
    public static void initialize() {

        loadNewOrders();

        orProductIds.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("productIdOrder"));
        orCusId.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("customerId"));
        orDescription.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("descriptionOfOrder"));
        orTotalPrice.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("totalPrice"));
        orAssignedEmp.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("assignedEmployee"));
        orStatus.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("status"));
        orDate.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("date"));

        ordersTable.getColumns().add(orProductIds);
        ordersTable.getColumns().add(orCusId);
        ordersTable.getColumns().add(orDescription);
        ordersTable.getColumns().add(orTotalPrice);
        ordersTable.getColumns().add(orAssignedEmp);
        ordersTable.getColumns().add(orStatus);
        ordersTable.getColumns().add(orDate);

        ordersTable.setItems(App.newOrders);

        ordersTable.setRowFactory(rowClick -> {
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
                    oDate.setText(String.valueOf(clickedRow.getDate()));
                }
            });
            return row;
        });

        loadChurroItems();

        itemId.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("productId"));
        itemName.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("name"));
        itemDescrip.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("description"));
        itemStnCost.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("standardCost"));
        itemStock.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("stock"));
        itemSupp.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("supplier"));
        itemCat.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("category"));

        churroItemsTable.getColumns().add(itemId);
        churroItemsTable.getColumns().add(itemName);
        churroItemsTable.getColumns().add(itemDescrip);
        churroItemsTable.getColumns().add(itemStnCost);
        churroItemsTable.getColumns().add(itemStock);
        churroItemsTable.getColumns().add(itemSupp);
        churroItemsTable.getColumns().add(itemCat);


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

        loadCustomerData();

        cusId.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("customerIdCs"));
        cusName.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("customerName"));
        cusDescription.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("descriptionOfOrderCustomer"));
        cusContact.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("contact"));
        cusDateOfPur.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("dateOfPurchase"));
        cusReview.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("review"));


        customerTable.getColumns().add(cusId);
        customerTable.getColumns().add(cusName);
        customerTable.getColumns().add(cusDescription);
        customerTable.getColumns().add(cusContact);
        customerTable.getColumns().add(cusDateOfPur);
        customerTable.getColumns().add(cusReview);


        customerTable.setItems(App.newCustomers);

        customerTable.setRowFactory(rowClick -> {
            TableRow<NewCustomer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    NewCustomer clickedRow = row.getItem();
                    csCusId.setText(Long.toString(clickedRow.getCustomerIdCs()));
                    csName.setText(clickedRow.getCustomerName());
                    csDescrip.setText(clickedRow.getDescriptionOfOrderCustomer());
                    csContact.setText(Long.toString(clickedRow.getContact()));
                    csDateOfPur.setText(Integer.toString(clickedRow.getDateOfPurchase()));
                    csReview.setText(clickedRow.getReview());
                }
            });
            return row;
        });

        loadEmployeeData();

        empId.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("employeeId"));
        empName.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("employeeName"));
        empShift.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("shift"));
        empOrdAssigned.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("ordersAssigned"));
        empSrtContract.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("startContract"));
        empFinContract.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("finishContract"));

        employeeTable.getColumns().add(empId);
        employeeTable.getColumns().add(empName);
        employeeTable.getColumns().add(empShift);
        employeeTable.getColumns().add(empOrdAssigned);
        employeeTable.getColumns().add(empSrtContract);
        employeeTable.getColumns().add(empFinContract);

        employeeTable.setItems(App.newEmployees);

        employeeTable.setRowFactory(rowClick -> {
            TableRow<NewEmployee> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    NewEmployee clickedRow = row.getItem();
                    eId.setText(Long.toString(clickedRow.getEmployeeId()));
                    eName.setText(clickedRow.getEmployeeName());
                    eShift.setText(clickedRow.getShift());
                    eOrdAssign.setText(clickedRow.getOrdersAssigned());
                    eSrtCon.setText(Integer.toString(clickedRow.getStartContract()));
                    eFinCon.setText(Integer.toString(clickedRow.getFinishContract()));
                }
            });
            return row;

        });

    }


    public static void loadNewOrders() {

        Gson gson = new Gson();
        try (Reader reader = new FileReader("newOrderJson.Json")) {
            ArrayList<NewOrder> imports = gson.fromJson(reader, new TypeToken<ArrayList<NewOrder>>() {
            }.getType());
            App.newOrders = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void loadChurroItems() {

        Gson gson = new Gson();
        try (Reader reader = new FileReader("foodItemsJson.Json")) {
            ArrayList<FoodItem> imports = gson.fromJson(reader, new TypeToken<ArrayList<FoodItem>>() {
            }.getType());
            App.foodItems = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (FoodItem i: App.foodItems
             ) {
            System.out.println(i);
        }
    }

    public static void loadCustomerData() {

        Gson gson = new Gson();
        try (Reader reader = new FileReader("newCustomerJson.Json")) {
            ArrayList<NewCustomer> imports = gson.fromJson(reader, new TypeToken<ArrayList<NewCustomer>>() {
            }.getType());
            App.newCustomers = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadEmployeeData() {

        Gson gson = new Gson();
        try (Reader reader = new FileReader("newEmployeeJson.Json")) {
            ArrayList<NewOrder> imports = gson.fromJson(reader, new TypeToken<ArrayList<NewEmployee>>() {
            }.getType());
            App.newOrders = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // to do: find ways to tell the user to correct the format they used to write (verification)
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
