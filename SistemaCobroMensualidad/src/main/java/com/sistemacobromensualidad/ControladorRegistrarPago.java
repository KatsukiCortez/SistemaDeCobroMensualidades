package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import java.io.IOException;
import javafx.fxml.FXML;
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
    
    @FXML
    private void initialize(){
        
    }
    
    @FXML
    private void handleVolver(){
        dialogStage.close();
    }
    
    public void setStudent(StudentJavaFX student){
        this.student = student;
        
        Lnombre.setText(student.getNombre());
        Lappat.setText(student.getAppat());
        Lapmat.setText(student.getApmat());
        Lgrado.setText(String.valueOf(student.getGrado()));
        Lseccion.setText(student.getSeccion());
        
    }
}
