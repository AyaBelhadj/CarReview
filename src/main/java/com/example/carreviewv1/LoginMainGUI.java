package com.example.carreviewv1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMainGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
       // Parent root=FXMLLoader.load(getClass().getResource("LoginMain.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(LoginMainGUI.class.getResource("LoginMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),500,389);
       // Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}
