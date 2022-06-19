package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class SecondaryController {

    public TableView icecreamItemsTable;
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
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(219, 168, 254), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlProducts.toFront();

        } else if (event.getSource() == btnCustomers) {
            lblTitleUnit.setText("CUSTOMERS");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(152, 168, 254), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlCustomers.toFront();

        } else if (event.getSource() == btnEmployees) {
            lblTitleUnit.setText("EMPLOYEES");
            pnlTitle.setBackground(new Background(new BackgroundFill(Color.rgb(7, 168, 254), CornerRadii.EMPTY, Insets.EMPTY)));
            pnlEmployees.toFront();
        }
    }

    public void switchToPrimary(ActionEvent actionEvent) throws IOException {
        App.setRoot("primary");
    }

    //ORDERS TABLE

    public TextField oProdId;
    public TextField oCusId;
    public TextArea oDescrip;
    public TextField oTotPr;
    public TextField oAssEm;
    public TextField oStatus;
    public TextField oDate;
    public TableView ordersTable;
    public TableColumn<NewOrder, Long> orProductIds = new TableColumn("Product Ids");
    public TableColumn<NewOrder, Long> orCusId = new TableColumn<>("Customer Id");
    public TableColumn<NewOrder, String> orDescription = new TableColumn<>("Description");
    public TableColumn<NewOrder, Double> orTotalPrice = new TableColumn<>("Total Price");
    public TableColumn<NewOrder, String> orAssignedEmp = new TableColumn<>("Assigned Employee");
    public TableColumn<NewOrder, String> orStatus = new TableColumn<>("Status");
    public TableColumn<NewOrder, Date> orDate = new TableColumn<>("Date");


    // INVENTORY TABLE (example)

    // 1#
    public TextField cProdId;
    public TextField cName;
    public TextArea cDescrip;
    public TextField cStandCost;
    public TextField cStock;
    public TextField cSupplier;
    public TextField cAmtLeft;
    public TableView churroItemsTable;
    public TableColumn<FoodItem, Long> itemId = new TableColumn<>("Item. Id");
    public TableColumn<FoodItem, String> itemName = new TableColumn<>("Name");
    public TableColumn<FoodItem, String> itemDescrip = new TableColumn<>("Description");
    public TableColumn<FoodItem, Double> itemStnCost = new TableColumn<>("Standard Cost");
    public TableColumn<FoodItem, Integer> itemStock = new TableColumn<>("Stock");
    public TableColumn<FoodItem, String> itemSupp = new TableColumn<>("Supplier");
    public TableColumn<FoodItem, Double> itemAmtLeft = new TableColumn<>("Amount Left");

    //PRODUCTS

    public TextField pProdId;
    public TextField pCategory;
    public TextField pDateMade;
    public TextField pExpDate;
    public TextField pAmtProduced;
    public TableView productsChurroTable;
    public TableColumn<AddProduct, Long> prodId = new TableColumn<>("Prod. Id");
    public TableColumn<AddProduct, String> prodCategory = new TableColumn<>("Category");
    public TableColumn<AddProduct, Date> prodDateMade = new TableColumn<>("Date Made");
    public TableColumn<AddProduct, Date> prodExpirationDate = new TableColumn<>("Expiration Date");
    public TableColumn<AddProduct, Integer> prodAmountProduced = new TableColumn<>("Amount Produced");

    //CUSTOMERS
    public TextField csCusId;
    public TextField csName;
    public TextArea csDescrip;
    public TextField csContact;
    public TextField csDateOfPur;
    public TextField csReview;
    public TableView customerTable;
    public TableColumn<NewCustomer, Long> cusId = new TableColumn<>("Customer. Id");
    public TableColumn<NewCustomer, String> cusName = new TableColumn<>("Name");
    public TableColumn<NewCustomer, String> cusDescription = new TableColumn<>("Description");
    public TableColumn<NewCustomer, Long> cusContact = new TableColumn<>("Contact");
    public TableColumn<NewCustomer, Date> cusDateOfPur = new TableColumn<>("Date of Purchase");
    public TableColumn<NewCustomer, String> cusReview = new TableColumn<>("Customer Review");

    // EMPLOYEES
    public TextField eId;
    public TextField eName;
    public TextField eShift;
    public TextField eOrdAssign;
    public TextField eSrtCon;
    public TextField eFinCon;
    public TableView employeeTable;
    public TableColumn<NewEmployee, Long> empId = new TableColumn<>("Emp. Id");
    public TableColumn<NewEmployee, String> empName = new TableColumn<>("Name");
    public TableColumn<NewEmployee, String> empShift = new TableColumn<>("Shift");
    public TableColumn<NewEmployee, String> empOrdAssigned = new TableColumn<>("Order Assigned");
    public TableColumn<NewEmployee, Date> empSrtContract = new TableColumn<>("Start Contract");
    public TableColumn<NewEmployee, Date> empFinContract = new TableColumn<>("Finish Contract");

    // ORDERS
    public void initialize() {

        loadNewOrders();

        orProductIds.setCellValueFactory(new PropertyValueFactory<NewOrder, Long>("productIdOrder"));
        orCusId.setCellValueFactory(new PropertyValueFactory<NewOrder, Long>("customerId"));
        orDescription.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("descriptionOfOrder"));
        orTotalPrice.setCellValueFactory(new PropertyValueFactory<NewOrder, Double>("totalPrice"));
        orAssignedEmp.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("assignedEmployee"));
        orStatus.setCellValueFactory(new PropertyValueFactory<NewOrder, String>("status"));
        orDate.setCellValueFactory(new PropertyValueFactory<NewOrder, Date>("date"));

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

        loadProductData();

        prodId.setCellValueFactory(new PropertyValueFactory<AddProduct, Long>("prodProductId"));
        prodCategory.setCellValueFactory(new PropertyValueFactory<AddProduct, String>("productCategory"));
        prodDateMade.setCellValueFactory(new PropertyValueFactory<AddProduct, Date>("dateMade"));
        prodExpirationDate.setCellValueFactory(new PropertyValueFactory<AddProduct, Date>("dateExpired"));
        prodAmountProduced.setCellValueFactory(new PropertyValueFactory<AddProduct, Integer>("amountProduced"));

        productsChurroTable.getColumns().add(prodId);
        productsChurroTable.getColumns().add(prodCategory);
        productsChurroTable.getColumns().add(prodDateMade);
        productsChurroTable.getColumns().add(prodExpirationDate);
        productsChurroTable.getColumns().add(prodAmountProduced);


        productsChurroTable.setItems(App.addProducts);

        productsChurroTable.setRowFactory(rowClick -> {
            TableRow<AddProduct> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    AddProduct clickedRow = row.getItem();
                    pProdId.setText(Long.toString(clickedRow.getProdProductId()));
                    pCategory.setText(clickedRow.getProductCategory());
                    pDateMade.setText(String.valueOf(clickedRow.getDateMade()));
                    pExpDate.setText(String.valueOf(clickedRow.getDateExpired()));
                    pAmtProduced.setText(Integer.toString(clickedRow.getAmountProduced()));
                }
            });
            return row;
        });

        loadChurroItems();

        itemId.setCellValueFactory(new PropertyValueFactory<FoodItem, Long>("productId"));
        itemName.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("name"));
        itemDescrip.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("description"));
        itemStnCost.setCellValueFactory(new PropertyValueFactory<FoodItem, Double>("standardCost"));
        itemStock.setCellValueFactory(new PropertyValueFactory<FoodItem, Integer>("stock"));
        itemSupp.setCellValueFactory(new PropertyValueFactory<FoodItem, String>("supplier"));
        itemAmtLeft.setCellValueFactory(new PropertyValueFactory<FoodItem, Double>("amountLeft"));

        churroItemsTable.getColumns().add(itemId);
        churroItemsTable.getColumns().add(itemName);
        churroItemsTable.getColumns().add(itemDescrip);
        churroItemsTable.getColumns().add(itemStnCost);
        churroItemsTable.getColumns().add(itemStock);
        churroItemsTable.getColumns().add(itemSupp);
        churroItemsTable.getColumns().add(itemAmtLeft);

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
                    cAmtLeft.setText(Double.toString(clickedRow.getCategory()));
                }
            });
            return row;
        });

        loadCustomerData();

        cusId.setCellValueFactory(new PropertyValueFactory<NewCustomer, Long>("customerIdCs"));
        cusName.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("customerName"));
        cusDescription.setCellValueFactory(new PropertyValueFactory<NewCustomer, String>("descriptionOfOrderCustomer"));
        cusContact.setCellValueFactory(new PropertyValueFactory<NewCustomer, Long >("contact"));
        cusDateOfPur.setCellValueFactory(new PropertyValueFactory<NewCustomer, Date>("dateOfPurchase"));
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
                    csDateOfPur.setText(String.valueOf(clickedRow.getDateOfPurchase()));
                    csReview.setText(clickedRow.getReview());
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
        for (NewOrder i: App.newOrders
            ){
            System.out.println(i);
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

    public static void loadProductData() {

        Gson gson = new Gson();
        try (Reader reader = new FileReader("newProductJson.Json")) {
            ArrayList<AddProduct> imports = gson.fromJson(reader, new TypeToken<ArrayList<AddProduct>>() {
            }.getType());
            App.addProducts = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (AddProduct i: App.addProducts
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
        for (NewCustomer i: App.newCustomers
            ){
            System.out.println(i);
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
                SecondaryController.class.getResource("btnProductsAddOrder.fxml"));
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

}
