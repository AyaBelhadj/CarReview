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
import java.util.zip.InflaterInputStream;

public class RenaultController implements Initializable {

    @FXML
    private AnchorPane homeRen;

    @FXML
    private JFXButton btn1_ren;

    @FXML
    private JFXButton btn2_ren;

    @FXML
    private JFXButton btn4_ren;

    @FXML
    private JFXButton btn3_ren;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void backAction(MouseEvent mouseEvent) {
     //   back.getScene().getWindow().hide();
        homeRen.setVisible(false);
    }
}
