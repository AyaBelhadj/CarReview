package com.example.carreviewv1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUPGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(SignUPGUI.class.getResource("SignUP.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),521,446);

        primaryStage.setTitle("Sign UP");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
