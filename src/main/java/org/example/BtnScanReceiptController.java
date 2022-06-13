package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;


import javafx.scene.Scene;

import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;


public class BtnScanReceiptController implements Initializable {


    public Button btnOpenImageSc;
    public Button btnReadReceiptSc;
    public Button btnLeaveScanReceiptSc;
    public Button btnDisplayImages;
    public ListView openImageList;


    ArrayList<File> receipts = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void handleBtnOpenImage(ActionEvent actionEvent) {

        /**
         * * https://www.youtube.com/watch?v=ytHsYpw1McU
         * */

    final FileChooser fc = new FileChooser();

    fc.setTitle("My File Chooser");

    fc.setInitialDirectory(new File(System.getProperty("user.home")));

    fc.getExtensionFilters().clear();
    fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All Files", "*.jpeg*"));

    List<File> tempFiles = fc.showOpenMultipleDialog(null);
    for (int i = 0; i < tempFiles.size(); i++) {
        /*
        * 1. copy file to the receipt in this project
        * 2. Add new file (the one placed in the receipt folder) into a new arrayList
        * 3. Make  a new loop and add all those newly made ones
         */


        /*
        *File dest = new File ("ScannedReceipts\\"+todayDateAndSecond+ i + ".jpg");
        *String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
         */

        File dest = new File ("ScannedReceipts\\receipt01.jpg");
        try {
            FileUtils.copyFile(tempFiles.get(i), dest);
            receipts.add(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (receipts != null) {
            openImageList.getItems().add(receipts.get(i));
        }
    }

    }
    public void toShoppingList(ActionEvent actionEvent) {
        //Save button


    }
    public void handleBtnDisplayImages(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                BtnInventoryShoppingListController.class.getResource("btnDisplayImages.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Your Receipts");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();

    }

    public void handleBtnReadReceipt(ActionEvent actionEvent) {

    // tesseracts scan

        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("tessdata");
            tesseract.setLanguage("spa");

            // the path of your tess data folder
            // inside the extracted file
            String text = tesseract.doOCR(receipts.get(0));

            // path of your image file
            System.out.print(text);
        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
    }

}

