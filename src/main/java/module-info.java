module com.example.tplivresihm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tplivresihm to javafx.fxml;
    exports com.example.tplivresihm;
}