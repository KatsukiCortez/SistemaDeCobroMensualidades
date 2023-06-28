module com.sistemacobromensualidad {
    requires javafx.controls;
    requires javafx.fxml;
    //requires javax.persistence;

    opens com.sistemacobromensualidad to javafx.fxml;
    exports com.sistemacobromensualidad;
}
