package com.sistemacobromensualidad;

import javafx.fxml.FXML;

public class ControladorListaEstudiantes {
    //Constructor
    public ControladorListaEstudiantes(){}
    private App app;
    
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
