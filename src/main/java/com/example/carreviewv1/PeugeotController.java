package com.example.carreviewv1;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PeugeotController  implements Initializable {
    @FXML
    private AnchorPane homePeug;

    @FXML
    private JFXButton btn1_peug;

    @FXML
    private JFXButton btn2_peug;

    @FXML
    private JFXButton btn4_peug;

    @FXML
    private JFXButton btn3_peug;

    @FXML
    private ImageView img_kia;

    @FXML
    private ImageView img_volk;

    @FXML
    private ImageView img_mazda;

    @FXML
    private ImageView img_peug;

    @FXML
    private Button back;

    @FXML
    public void backAction(javafx.scene.input.MouseEvent mouseEvent) {
        //back.getScene().getWindow().hide();
        homePeug.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
