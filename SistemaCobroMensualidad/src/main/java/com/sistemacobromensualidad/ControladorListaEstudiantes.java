package com.sistemacobromensualidad;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ControladorListaEstudiantes {
    //Constructor
    public ControladorListaEstudiantes(){}
    private App app;
    //private boolean okClicked = false;
    
    public void setApp(App app) {
        this.app = app;
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
        //app.showGradoSeccion();
    }
    
    
}
