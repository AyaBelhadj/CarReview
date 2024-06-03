module com.example.carreviewv1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;


    opens com.example.carreviewv1 to javafx.fxml;
    exports com.example.carreviewv1;
}