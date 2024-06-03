package com.example.carreviewv1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;


public class LoginMainController  implements Initializable {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private AnchorPane parent;
    @FXML
    private JFXTextField tf_UName;
    @FXML
    private JFXPasswordField tf_Passwrd;
    @FXML
    private JFXCheckBox chb_rmbrMe;
    @FXML
    private JFXButton btn_sgnUP;
    @FXML
    private JFXButton btn_login;
    @FXML
    private JFXButton btn_frgt;
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
    private Connection conn;
    private Main handler;
    private PreparedStatement pst;

    private static LoginMainController instance;
    public LoginMainController(){
        instance=this;
    }
    public static LoginMainController getInstance(){
        return instance;
    }
    public  String userName(){
        return tf_UName.getText();

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        img_buttom.setVisible(false);
        tf_UName.setStyle("-fx-text-inner-color: #a0a2ab;");
        tf_Passwrd.setStyle("-fx-text-inner-color: #a0a2ab;");
        //handler=new Main();
    }
    @FXML
    public void loginAction(ActionEvent e)  {
        img_buttom.setVisible(true);
        PauseTransition pt=new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(actionEvent -> {
            UserDao dao=new UserDao();
            String q1="select * from user where Uname =? and Password =?";
            try {
                ResultSet rs=dao.login(tf_UName.getText(),tf_Passwrd.getText());
               /* pst= dao.con.prepareStatement(q1);
                pst.setString(1,tf_UName.getText());
                pst.setString(2,tf_Passwrd.getText());
                //pst.executeUpdate();
                ResultSet rs= dao.select(q1);*/
                int count=0;
                boolean test = true;
                while (rs.next()&&test) {
                    System.out.println("tsst");
                   /* System.out.println(rs.getString("Uname"));
                    System.out.println(tf_UName.getText());
                    System.out.println(rs.getString("Password"));
                    System.out.println(tf_Passwrd.getText());*/
                    String ch1,ch2,ch3,ch4;
                    ch1=new String(rs.getString(1));
                   // ch1= rs.getString(1);
                    //ch2=rs.getString(2);
                    ch2=new String(rs.getString(2));
                    //ch3=tf_UName.getText();
                    //ch4=tf_Passwrd.getText();
                    ch3=new String(tf_UName.getText());
                    ch4=new String(tf_Passwrd.getText());
                    //boolean test3=ch1==ch3;
                   // boolean test4=ch2==ch4;
                    boolean test3=ch1.equals(ch3);
                    boolean test4=ch2.equals(ch4);
                    /*System.out.println(ch1);
                    System.out.println(ch2);
                    System.out.println(ch3);
                    System.out.println(ch4);*/

                    // boolean test1=rs.getString(1)==tf_UName.getText();
                  //  System.out.println(rs.getString(1));
                   // boolean test2=rs.getString(2)==tf_Passwrd.getText();
                   // System.out.println(rs.getString(2));
                   // System.out.println(test1);
                    //System.out.println(test2);
                  /*  System.out.println(test3);
                    System.out.println(test4);*/
                    if((test3 == true)&&(test4== true))
                    {
                        System.out.println("tessst");
                        test=false;
                    }

                    /*if((rs.getString("Uname") == (tf_UName.getText()))&&(rs.getString("Password") == (tf_Passwrd.getText())))
                    {
                        System.out.println("tessst");
                        test=false;
                    }*/
                    count=count+1;

                }
                if (test==false){
                    //System.out.print("login Successful!");
                    btn_login.getScene().getWindow().hide();
                    Stage home=new Stage();


                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("HomePage.fxml"));
                        Scene scene ;
                        scene = new Scene(fxmlLoader.load(),808,600);
                        home.setScene(scene);
                        home.show();
                     /*catch (IOException ex) {
                        //throw new RuntimeException(ex);
                        System.out.println(ex.getMessage());
                    }*/
                    System.out.println("Client!");

                        Socket s=new Socket("127.0.0.1",9001);
                        System.out.println("je suis un client et je suis accepte");
                        /*Scanner sc=new Scanner(System.in);
                        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                        String ligne= br.readLine();
                        System.out.println(ligne);
                        String id=sc.nextLine();*/
                        String id=tf_UName.getText();
                        PrintWriter pw=new PrintWriter(s.getOutputStream());
                        pw.println(id);
                        pw.flush();
                    }
                    catch (IOException ex1) {
                        System.out.println(ex1.getMessage());
                    }
                }



                else {
                    // System.out.print("User name and Passord is not correct !");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("User name and Passord is not correct !");
                    alert.show();
                    img_buttom.setVisible(false);
                }

            } catch (SQLException ex) {
                //throw new RuntimeException(ex);
                System.out.println(ex.getMessage());
            }
           /* finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //throw new RuntimeException(ex);
                    System.out.println(ex.getMessage());
                    // ex.printStackTrace();
                }
            }*/

       /*     //System.out.print("Login succesfully !");
            String nom_driver="com.mysql.jdbc.Driver";
            try {
                Class.forName(nom_driver);
                System.out.println("driver charge");
                conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/carreviewdatabase","root","");
                System.out.println("connected");
                String q1="select * from user where Uname=? and Password=?";
                pst=conn.prepareStatement(q1);
                pst.setString(1,tf_UName.getText());
                pst.setString(2,tf_Passwrd.getText());
                ResultSet rs= pst.executeQuery();
                int count=0;
                while (rs.next()){
                    count=count+1;

                }
                if (count==1){
                    //System.out.print("login Successful!");
                    btn_login.getScene().getWindow().hide();
                    Stage home=new Stage();

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("HomePage.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(),521,446);
                        home.setScene(scene);
                        home.show();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                       // throw new RuntimeException(ex);
                    }
                }
                else {
                    // System.out.print("User name and Passord is not correct !");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("User name and Passord is not correct !");
                    alert.show();
                    img_buttom.setVisible(false);
                }


            } catch (ClassNotFoundException ex) {
                System.out.println("erreur driver"+ex.getMessage());
            }
            catch (SQLException ex) {
                System.out.println("erreur connection"+ex.getMessage());
            }
            finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //throw new RuntimeException(ex);
                    System.out.println(ex.getMessage());
                   // ex.printStackTrace();
                }
            }
*/

        });

        pt.play();

    }
    @FXML
    public void signUp(ActionEvent ev) throws IOException {

        btn_sgnUP.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignUP.fxml"));
        Scene scene ;
        scene = new Scene(fxmlLoader.load());
        Stage signup=new Stage();
        signup.setTitle("Sign UP!");
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);



    }

}
