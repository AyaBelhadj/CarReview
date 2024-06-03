package com.example.carreviewv1;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class VolkswagenController {
    @FXML
    private AnchorPane homeVolk;

    @FXML
    private JFXButton btn1_volk;

    @FXML
    private JFXButton btn2_volk;

    @FXML
    private JFXButton btn4_volk;

    @FXML
    private JFXButton btn3_volk;

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

    public void backAction(MouseEvent mouseEvent) {
       // back.getScene().getWindow().hide();
        homeVolk.setVisible(false);
    }
}
