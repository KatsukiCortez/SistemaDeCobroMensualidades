package com.sistemacobromensualidad;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControladorRegistrarPago {
    //Constructor
    public ControladorRegistrarPago(){}

    private Stage dialogStage;
    //private boolean okClicked = false;
    
    //Referenciar la aplicacion principal
    private App app;

    public void setApp(App app) {
        this.app = app;
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void initialize(){
    }
    
    @FXML
    private void handleVolver(){
        dialogStage.close();
    }
}
