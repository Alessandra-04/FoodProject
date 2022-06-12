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
import java.util.List;
import java.util.ResourceBundle;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class BtnScanReceiptController implements Initializable {


    public Button btnOpenImageSc;

    public Button btnReadReceiptSc;
    public Button btnLeaveScanReceiptSc;
    public Button btnDisplayImages;
    public ListView openImageList;

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
            new FileChooser.ExtensionFilter("All Files", "*.*"),
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));

    List<File> files = fc.showOpenMultipleDialog(null);

    for (int i = 0; i < files.size(); i++) {
        if (files != null) {
            openImageList.getItems().add(files.get(i));
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

    // tesseract scan

        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("D:/Tess4J/tessdata");

            // the path of your tess data folder
            // inside the extracted file
            String text
                    = tesseract.doOCR(new File("IMG_1002.jpg"));

            // path of your image file
            System.out.print(text);
        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
    }

}

