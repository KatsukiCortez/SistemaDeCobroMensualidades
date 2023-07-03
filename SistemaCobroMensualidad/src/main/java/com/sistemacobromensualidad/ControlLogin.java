/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Xeride
 */
public class ControlLogin {
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtcontraseña;
    
    private Stage dialogStage;
    private App app;
    private StudentJavaFX student;
    private boolean okClicked = false;
    
    public void setApp(App app) {
        this.app = app;
    }
    
    public ControlLogin(){}
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    @FXML
    public void handleIngresar(){
        String user=txtuser.getText();
        String contra=txtcontraseña.getText();
    }
    
    @FXML
    public void handleSalir(){
        dialogStage.close();
    }
    
}
