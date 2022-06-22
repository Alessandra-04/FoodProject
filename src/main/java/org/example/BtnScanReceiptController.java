package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;


import javafx.scene.Scene;

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
import java.util.regex.*;


public class BtnScanReceiptController implements Initializable {


    public Button btnOpenImageSc;
    public Button btnReadReceiptSc;
    public Button btnLeaveScanReceiptSc;
    public ListView openImageList;
    public TextArea txtReceipt;

    public TextField cProdId;


    ArrayList<File> receipts = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void handleBtnOpenImage(ActionEvent actionEvent) {

        /*
         * https://www.youtube.com/watch?v=ytHsYpw1McU
         */

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

        String saveText = txtReceipt.getText();
        System.out.println(cProdId);

        // save scan

    }

    public void handleBtnReadReceipt(ActionEvent actionEvent) {

        /*
         * https://www.geeksforgeeks.org/tesseract-ocr-with-java-with-examples/
         */


        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("tessdata");
            tesseract.setLanguage("spa");

            // the path of your tess data folder
            // inside the extracted file
            String text = tesseract.doOCR(receipts.get(0));

            // path of your image file
            System.out.print(text);

            txtReceipt.setText(text);

            /*
             * https://www.tutorialspoint.com/javaregex/javaregex_capturing_groups.htm
             */

            String itemsPattern = "([0-9]{13})\\s+([a-z,A-Z,\\s.]+).*(\\s[0-9]{1,2}[,.][0-9]{2})";
            Pattern itemPattern = Pattern.compile(itemsPattern, Pattern.MULTILINE);
            Matcher matchItem = itemPattern.matcher(text);
            String showText = "";
            while (matchItem.find()){
                    showText = showText + matchItem.group(1) + "\n";
                    if (showText.contains(foodItems) = true)

                    // 1. check if the item already exists in fooditems.
                // 2. if it exists add a number to that fooditem
                //3. if it doesn't exist create a new food item and add the number bought.

                    App.foodItems.add(new FoodItem(matchItem.group(0) ,matchItem.group(2), matchItem.group(3)));
                    // access churros table and put each item on the right column

                }
            txtReceipt.setText(showText);

            /*
            String datesPattern = "(Fecha de Emision:([0-9]{2})/([0-9]{2})/([0-9]{4}))";
            Pattern datePattern = Pattern.compile(datesPattern, Pattern.MULTILINE);
            Matcher matchDate = datePattern.matcher(text);
            String showDate = "";
            while (matchDate.find()){
                showDate = showDate + matchDate.group() + "\n";

            }
            txtReceipt.setText(showDate);

            String timesPattern = "(Hora:([0-9]{2}):([0-9]{2}))";
            Pattern timePattern = Pattern.compile(timesPattern, Pattern.MULTILINE);
            Matcher matchTime = timePattern.matcher(text);
            String showTime = "";
            while (matchTime.find()){
                showTime = showTime + matchTime.group() + "\n";

            }
            txtReceipt.setText(showTime);

             */


            //tempName = ""
            //itemList{}
            //Int newItemFound = 0
            //int PriceFound =0
            //split string by spaces
            //for each splitItem
            //	if it is 12 digits
            //		newItemFound =1
            //		itemList.add new item
            //	if newItemFound = 1 && PriceFound==0
            //		tempName=+ split+ " "
            //	if split = xx.xx or x.xx
            //		pricefound=1
            //		itemList.set Name of the last item to tempName
            //		tempName=""
            //		itemList.set price oflast item to split
            //		newItemFound=0
            //		pricefound=0




        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
    }

}

