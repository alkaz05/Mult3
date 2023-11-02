module com.example.mult3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mult3 to javafx.fxml;
    exports com.example.mult3;
}