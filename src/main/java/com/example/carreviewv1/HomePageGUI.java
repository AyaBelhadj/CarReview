package com.example.carreviewv1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageGUI extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            // Pane root=new Pane();
            // Scene scene = new Scene(root, 820, 450);
            stage.setTitle("HomePage");
            stage.setScene(scene);
            stage.show();

        }

        public static void main(String[] args) {
            launch();
        }

}
