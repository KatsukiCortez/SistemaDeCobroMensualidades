/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
    ResultSet rs;
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
        
        app.showlog(user, contra);
    }
    
    @FXML
    public void handleSalir(){
        dialogStage.close();
    }
    
}
