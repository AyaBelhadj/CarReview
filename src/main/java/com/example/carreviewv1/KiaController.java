package com.example.carreviewv1;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class KiaController implements Initializable {

    @FXML
    private AnchorPane homeKia;

    @FXML
    private JFXButton btn1_kia;

    @FXML
    private JFXButton btn2_kia;

    @FXML
    private JFXButton btn4_kia;

    @FXML
    private JFXButton btn3_kia;

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
    @FXML
    public void backAction(javafx.scene.input.MouseEvent mouseEvent) {
        //back.getScene().getWindow().hide();
        homeKia.setVisible(false);
    }
}
