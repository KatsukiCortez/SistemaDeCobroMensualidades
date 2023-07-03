module com.sistemacobromensualidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;

    opens com.sistemacobromensualidad to javafx.fxml;
    exports com.sistemacobromensualidad;
}
