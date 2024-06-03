/**
 * Sample Skeleton for 'HomePage.fxml' Controller Class
 */

package com.example.carreviewv1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXToolbar;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController {
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Label lbPop;
    @FXML
    private Pane LeftPane;

    @FXML
    private JFXButton btn_home;

    @FXML
    private JFXButton btn_mycars;

    @FXML
    private JFXButton btn_about;

    @FXML
    private JFXButton btn_contactus;

    @FXML
    private Separator separator;

    @FXML
    private JFXToolbar toolbar;

   // @FXML
   // private Text welcometxt;

    @FXML
    private HBox hbtopright;

    @FXML
    private Label lbtopright;
    @FXML
    private JFXButton btn_logexit;
    @FXML
    private ImageView imgtopright;

    @FXML
    private VBox overflowcontainer;

    @FXML
    private JFXButton btn_logout;

    @FXML
    private JFXButton btn_exit;

    @FXML
    private AnchorPane holderPanee;
    @FXML
    private Label welcome;
private AnchorPane home;

    @FXML
    private Pane homePane;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    private LoginMainController l=new LoginMainController();



    @FXML // This method is called by the FXMLLoader when initialization is complete
    public void initialize(ResourceBundle resources,URL location) {
        JFXRippler rippler=new JFXRippler(lbtopright);
        rippler.setMaskType(JFXRippler.RipplerMask.RECT);
        toolbar.getChildren().add(rippler);
     //openMenus();
     createPage();
     setUsername(l.userName());

    }
    public void setUsername(String user){
        this.welcome.setText("Welcome, "+user);
    }
    @FXML
    void showPopupAction(MouseEvent event) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem logout = new MenuItem("Log Out ");
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    btn_logout.getScene().getWindow().hide();
                    Stage primaryStage=new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(LoginMainGUI.class.getResource("LoginMain.fxml"));
                    Scene scene = null;
                    scene = new Scene(fxmlLoader.load(),500,389);
                    primaryStage.setTitle("Login");
                    primaryStage.setResizable(false);
                    primaryStage.setScene(scene);
                    primaryStage.show();;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        MenuItem exit = new MenuItem("Exit ");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        contextMenu.getItems().addAll(logout,exit);
        contextMenu.setAutoHide(true);
        //lbPop.setContextMenu(contextMenu);
        btn_logexit.setContextMenu(contextMenu);
        btn_logexit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent contextMenuEvent) {
                contextMenu.show(overflowcontainer, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());


            }
        });

    }
   /* private void openMenus() {


        ContextMenu contextMenu = new ContextMenu();
        MenuItem logout = new MenuItem("Log Out ");
        MenuItem exit = new MenuItem("Exit ");
        contextMenu.getItems().addAll(logout,exit);
        contextMenu.setAutoHide(true);
        //lbPop.setContextMenu(contextMenu);
        btn_logexit.setContextMenu(contextMenu);
        btn_logexit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent contextMenuEvent) {
                contextMenu.show(contextMenu, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());


            }
        });

        Popup pop=new Popup();
        pop.setAutoHide(true);
        pop.getContent().addAll(btn_logout,btn_exit);
        Point2D point= btn_logexit.localToScreen(0,0);
        btn_logexit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pop.show(btn_logexit,point.getX()+ mouseEvent.getX(),point.getY()+mouseEvent.getY());
            }
        });


    }*/

    private void setNode(Node node){
        holderPanee.getChildren().clear();
        holderPanee.getChildren().add((Node)node);
        FadeTransition ft=new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();



 }

    @FXML
    void homeAction(MouseEvent event) {
        HomeController h=new HomeController();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("Home.fxml"));
            home=fxmlLoader.load();

            holderPanee.getChildren().add(home);
            FadeTransition ft=new FadeTransition(Duration.millis(1500));
            ft.setNode(home);
            ft.setFromValue(0.1);
            ft.setToValue(1);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
            /*home= fxmlLoader.load();
            holderPanee.getChildren().clear();
            holderPanee.getChildren().add((Node)home);*/
           /* FadeTransition ft=new FadeTransition(Duration.millis(1500));
            ft.setNode(home);
            ft.setFromValue(0.1);
            ft.setToValue(1);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();*/
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    private void createPage() {
        try {
           // HomeController h=new HomeController();
            FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("Home.fxml"));
            //home=h.getHome();
            home= fxmlLoader.load();
            setNode(home);

        } catch (IOException e) {
            System.out.println(e.getMessage());
           // throw new RuntimeException(e);
        }

    }
    @FXML
    void exit(ActionEvent event) {
        Platform.exit();

    }

    @FXML
    void logOut(ActionEvent event) {

        try {
            btn_logout.getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(LoginMainGUI.class.getResource("LoginMain.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load(),500,389);
            primaryStage.setTitle("Login");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }






}
