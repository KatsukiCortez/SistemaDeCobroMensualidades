
package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import javafx.event.ActionEvent;


public class ControladorCuotas {

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApPat;
    @FXML
    private Label lblApMat;
    @FXML
    private Label lblFecha;
    @FXML
    private Label lblGrado;
    @FXML
    private Label lblGenero;
    
    
    public ControladorCuotas() {
    }
    private App app;
    private StudentJavaFX student;
    private Stage dialogStage;
    private boolean okClicked = false;
    
    public void setApp(App app) {
        this.app = app;
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    public void setStudent(StudentJavaFX student){
        this.student = student;
        lblNombre.setText(student.getNombre());
        lblApPat.setText(student.getAppat());
        lblApMat.setText(student.getApmat());
        lblFecha.setText(student.getFecha());
        lblGrado.setText("Aun no asignado");
        lblGenero.setText("Humanos");
    }
    
    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}
