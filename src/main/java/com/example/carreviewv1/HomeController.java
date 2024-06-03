package com.example.carreviewv1;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController  implements Initializable {
    @FXML
    public AnchorPane home;
    private AnchorPane homeKia;
    private AnchorPane homePeug;
    private AnchorPane homeRen;
    private AnchorPane homeVolk;


    @FXML
    private JFXButton btn_kia;

    @FXML
    private ImageView img_kia;

    @FXML
    private JFXButton btn_volk;

    @FXML
    private ImageView img_volk;

    @FXML
    private JFXButton btn_peug;

    @FXML
    private ImageView img_peug;

    @FXML
    private JFXButton btn_renault;

    @FXML
    private ImageView img_renault;

    public AnchorPane getHome() {
        return home;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }






    @FXML
    public void kiaAction(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("Kia");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("kia.fxml"));
            homeKia=fxmlLoader.load();
            home.getChildren().add(homeKia);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }


    }
    @FXML
    public void vlokAction(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("volk");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("volkswagen.fxml"));
            homeVolk=fxmlLoader.load();
            home.getChildren().add(homeVolk);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void peugAction(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("peug");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("peugeot.fxml"));
            homePeug=fxmlLoader.load();
            home.getChildren().add(homePeug);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void renAction(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("ren");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("renault.fxml"));
            homeRen=fxmlLoader.load();
            home.getChildren().add(homeRen);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
}
