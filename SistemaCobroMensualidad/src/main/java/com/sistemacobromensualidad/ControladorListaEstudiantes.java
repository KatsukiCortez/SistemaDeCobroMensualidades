package com.sistemacobromensualidad;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ControladorListaEstudiantes {
    //Constructor
    public ControladorListaEstudiantes(){}

    private Stage dialogStage;
    //private boolean okClicked = false;
    
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
    private void handleVerCuotas() {
        //app.showGradoSeccion();
        app.showCuotas();
    }
    
    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}