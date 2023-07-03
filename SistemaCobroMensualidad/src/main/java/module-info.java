module com.sistemacobromensualidad {
    requires javafx.controls;  // Requiere el módulo JavaFX Controls
    requires javafx.fxml;  // Requiere el módulo JavaFX FXML
    requires java.sql;  // Requiere el módulo Java SQL
    requires jasperreports;  // Requiere el módulo JasperReports

    opens com.sistemacobromensualidad to javafx.fxml;  // Abre el paquete "com.sistemacobromensualidad" para su uso con JavaFX FXML
    exports com.sistemacobromensualidad;  // Exporta el paquete "com.sistemacobromensualidad" para su uso externo
}
