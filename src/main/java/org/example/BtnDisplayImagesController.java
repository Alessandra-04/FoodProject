package org.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class BtnDisplayImagesController extends Application {

    public TitledPane receipt1Pane;
    public TitledPane receipt2Pane;
    public TitledPane receipt3Pane;
    public TitledPane receipt4Pane;
    public TitledPane receipt5Pane;


    File filesJpg[];
    Image images[];
    ImageView imageViews[];
    BufferedImage bufferedImage[];
    TitledPane titledPanes[];

    @Override
    public void start(final Stage primaryStage) {
        openDirectoryChooser(primaryStage);
    }

    private void openDirectoryChooser(Stage parent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory =
                directoryChooser.showDialog(parent);

        if (selectedDirectory != null) {
            FilenameFilter filterJpg = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".jpg");
                }
            };

            filesJpg = selectedDirectory.listFiles(filterJpg);
            openTitledPane();
        }
    }

    private void openTitledPane(){
        int numOfJpg = filesJpg.length;
        images = new Image[numOfJpg];
        bufferedImage = new BufferedImage[numOfJpg];
        imageViews = new ImageView[numOfJpg];
        titledPanes = new TitledPane[numOfJpg];

        for (int i = 0; i < numOfJpg; i++) {
            try {
                File file = filesJpg[i];

                bufferedImage[i] = ImageIO.read(file);
                images[i] = SwingFXUtils.toFXImage(bufferedImage[i], null);
                imageViews[i] = new ImageView();
                imageViews[i].setImage(images[i]);
                imageViews[i].setFitWidth(400);
                imageViews[i].setPreserveRatio(true);
                imageViews[i].setSmooth(true);
                imageViews[i].setCache(true);
                titledPanes[i] = new TitledPane(String.valueOf(i), imageViews[i]);
            } catch (IOException ex) {
                Logger.getLogger(BtnDisplayImagesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Accordion accordion = new Accordion();
        accordion.getPanes().add(receipt1Pane);
        accordion.getPanes().add(receipt2Pane);
        accordion.getPanes().add(receipt3Pane);
        accordion.getPanes().add(receipt4Pane);
        accordion.getPanes().add(receipt5Pane);

        Stage titledPaneStage = new Stage();
        titledPaneStage.setTitle("TitledPane");
        titledPaneStage.show();
    }
}

