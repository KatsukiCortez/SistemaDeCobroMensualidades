module com.sistemacobromensualidad {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sistemacobromensualidad to javafx.fxml;
    exports com.sistemacobromensualidad;
}
