package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.stage.FileChooser;

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

import static org.example.App.foodItems;


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
            //System.out.print(text);

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
                    if (foodItems.contains(cProdId)){
                        cProdId.setText(matchItem.group(1));
                    }else{
                       long productId = Long.parseLong(matchItem.group(1));
                       String name = matchItem.group(2);
                       double standardCost = Double.parseDouble(matchItem.group(3));
                       int stock = 1;
                       int sizeOfContainer = 1000;
                       //if there is a double line (buying more than one of the same product
                        FoodItem tempItem = new FoodItem(productId, name, standardCost, sizeOfContainer);
                        /**
                         * loop through how many items brought
                         *      tempItem.addStock(i);
                         */
                       foodItems.add(tempItem);
                    }

                    // 1. check if the item already exists in foodItems.
                    // 2. if it exists add a number to that foodItem
                    //3. if it doesn't exist create a new food item and add the number bought.

                    foodItems.add(new FoodItem(Long.parseLong(matchItem.group(1)) ,matchItem.group(2), Double.parseDouble(matchItem.group(3)), 1000 ));

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

*/


        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
    }

}

