module com.mycompany.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.sistemamatriculas to javafx.fxml;
    exports com.mycompany.sistemamatriculas;
}
