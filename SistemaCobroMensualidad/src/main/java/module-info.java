module com.sistemacobromensualidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.sistemacobromensualidad to javafx.fxml;
    exports com.sistemacobromensualidad;
}
