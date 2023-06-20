/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemacobromensualidad;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ControladorRegistrarPago {

    public ControladorRegistrarPago() {
    }
    
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
    private void handleRepor() {
        //app.showReport();// esta line invoca a el metodo que genera reporte
    }
    
    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}
