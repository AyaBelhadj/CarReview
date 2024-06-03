package com.example.carreviewv1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class SignUPController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private AnchorPane parent;
    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXButton btn_login;
    @FXML
    private JFXButton btn_signup;
    @FXML
    private JFXTextField tf_Uname;
    @FXML
    private JFXTextField tf_loc;
    @FXML
    private JFXPasswordField tf_psswrd;
    @FXML
    private JFXRadioButton rdb_male;
    @FXML
    private JFXRadioButton rdb_female;
    @FXML
    private Label lb_car;
    @FXML
    private Label lb_review;
    @FXML
    private ImageView img_logo;
    @FXML
    private ImageView img_user;
    @FXML
    private ImageView img_lock;
    @FXML
    private ImageView img_buttom;
    @FXML
    private ImageView img_gender;
    @FXML
    private ImageView img_loc;

    private Connection conn;
    private Main handler;
    private PreparedStatement pst;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       img_buttom.setVisible(false);
        tf_Uname.setStyle("-fx-text-inner-color: #a0a2ab;");
        tf_psswrd.setStyle("-fx-text-inner-color: #a0a2ab;");
        tf_loc.setStyle("-fx-text-inner-color: #a0a2ab;");
        handler=new Main();


    }
    @FXML
    public void signUP(ActionEvent ev )
    {
        img_buttom.setVisible(true);
        PauseTransition pt=new PauseTransition(Duration.seconds(2));
        pt.setOnFinished(actionEvent -> {
            System.out.print("SignUP Successful !");
            try {
                btn_signup.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("HomePage.fxml"));
                Scene scene = null;
                scene = new Scene(fxmlLoader.load(),808,600);
                Stage login=new Stage();
                login.setTitle("Home!");
                login.setScene(scene);
                login.setResizable(false);
                login.show();

            } catch (IOException e) {
                // throw new RuntimeException(e);
                System.out.println(e.getMessage());
            }
        });
        pt.play();
        int a;
        UserDao dao=new UserDao();
        a= dao.insert(tf_Uname.getText(),tf_psswrd.getText(),getGender(),tf_loc.getText());





    }
    @FXML
    public void loginAction(ActionEvent ev ) throws IOException {
        btn_login.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage login=new Stage();
        login.setTitle("Login!");
        login.setScene(scene);
        login.show();
        login.setResizable(false);
    }

public String  getGender(){
        String gen="";
        if (rdb_male.isSelected()){
            gen="Male";
        }
        else if (rdb_female.isSelected()){
            gen="Female";
        }
return gen;

}
}