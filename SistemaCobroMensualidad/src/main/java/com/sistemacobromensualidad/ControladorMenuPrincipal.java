package com.sistemacobromensualidad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControladorMenuPrincipal {
    // Referencia a la aplicacion principal
    private App app;
    private Stage dialogStage;
    private boolean okClicked = false;
    
    // Constructor
    public ControladorMenuPrincipal() {
    }
    
    @FXML
    private void initialize(){
    }
    
    public void setApp(App app) {
        this.app = app;
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void handleEstudiantes() {
        app.showGradoSeccion();
    }

    @FXML
    private void handleMatriculas() {
        app.showMatricula();
    }

    @FXML
    private void handleSalir() {
        // Acciones al hacer clic en el botón "Salir"
        System.exit(0); // Sale de la aplicación
    }
}
