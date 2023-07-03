package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class ControladorRegistrarPago {
    
    @FXML
    private Label Lnombre;
    @FXML
    private Label Lappat;
    @FXML
    private Label Lapmat;
    @FXML
    private Label Lgrado;
    @FXML
    private Label Lseccion;
    
    @FXML
    private RadioButton RBmatricula;
    @FXML
    private RadioButton RBpension;

    private StudentJavaFX student;
    
    //Constructor
    public ControladorRegistrarPago(){}

    private Stage dialogStage;
    private boolean okClicked = false;
    
    //Referenciar la aplicacion principal
    private App app;

    public void setApp(App app) {
        this.app = app;
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setStudent(StudentJavaFX student){
        this.student = student;
        Lnombre.setText(student.getNombre());
        Lappat.setText(student.getAppat());
        Lapmat.setText(student.getApmat());
        Lgrado.setText(String.valueOf(student.getGrado()));
        Lseccion.setText(student.getSeccion());
        
    }
    
    @FXML
    private void initialize(){    
    }

    @FXML
    private void btnGuardar(){
        String mensaje = "";
        String url = "jdbc:mysql://localhost:3306/cobros";
        String usuario = "root";
        String contraseña = "";
            
        if(RBmatricula.isSelected()){
            try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
                String query = "INSERT INTO pago (IDdni, IDCuota) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, student.getDni());
                    statement.setString(2, "C002");
                    int filasAfectadas = statement.executeUpdate();
                        if (filasAfectadas > 0) {
                            mensaje += "Exito, pago Matricula.";
                        } else {
                            mensaje += "Error, no se pago Matricula.";
                        }
                }catch(SQLException ex){
                    mensaje += "Error "+ex; 
                }
        } else if(RBpension.isSelected()){
            try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
                String query = "INSERT INTO pago (IDdni, IDCuota) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, student.getDni());
                    statement.setString(2, "C001");
                    int filasAfectadas = statement.executeUpdate();
                        if (filasAfectadas > 0) {
                            mensaje += "Exito, pago pension.";
                        } else {
                            mensaje += "Error, no se pago Matricula.";
                        }
                }catch(SQLException ex){
                    mensaje += "Error "+ex; 
                }
        }
        Alert exito = new Alert(Alert.AlertType.INFORMATION);
                exito.initOwner(dialogStage);
                exito.setTitle("Informacion.");
                exito.setHeaderText(mensaje);
                exito.showAndWait();
    }

    @FXML
    private void handleVolver(){
        dialogStage.close();
    }
    
}
