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
        if (user.equals("") && contra.equals("")){
            Alert dialog=new Alert(AlertType.INFORMATION);// crea un tipode dialogo de alerta simple
            dialog.setTitle("MENSAJE");
            dialog.setHeaderText(null);//Sin titulo interno
            dialog.setContentText("Falta completar datos en un campo");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.showAndWait();
        }
        else{
            String url = "jdbc:mysql://localhost:3306/cobros";
            String usuario = "root";
            String contraseña = "";
            try{
                Connection connection = DriverManager.getConnection(url, usuario, contraseña);
                
                PreparedStatement pst = connection.prepareStatement("select * from usuarios where id_usuario=? and usuario=?");
                pst.setString(1, user);
                pst.setString(2, contra);
                
                rs = pst.executeQuery();
                if(rs.next()){
                    Alert dialog=new Alert(AlertType.INFORMATION);// crea un tipode dialogo de alerta simple
                    dialog.setTitle("MENSAJE");
                    dialog.setHeaderText(null);//Sin titulo interno
                    dialog.setContentText("Ingreso exitoso");
                    dialog.initStyle(StageStyle.UTILITY);
                    dialog.showAndWait();
                }else{
                    Alert dialog=new Alert(AlertType.INFORMATION);// crea un tipode dialogo de alerta simple
                    dialog.setTitle("MENSAJE");
                    dialog.setHeaderText(null);//Sin titulo interno
                    dialog.setContentText("Ingreso Fallido, intente nuevamente");
                    dialog.initStyle(StageStyle.UTILITY);
                    dialog.showAndWait();
                }
            }catch(SQLException e){
                System.out.println("error en la conección"+e);
            }
        }
    }
    
    @FXML
    public void handleSalir(){
        dialogStage.close();
    }
    
}
