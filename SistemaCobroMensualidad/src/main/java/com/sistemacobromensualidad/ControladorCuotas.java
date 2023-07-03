
package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import javafx.event.ActionEvent;


public class ControladorCuotas {
    @FXML
    private TableView<StudentJavaFX> cuotasTabla;
    @FXML
    private TableColumn<StudentJavaFX, String> mesColumna;
    @FXML
    private TableColumn<StudentJavaFX, String> estadoColumna;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApPat;
    @FXML
    private TextField txtApMat;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtGrado;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtSeccion;
    
    private Stage dialogStage;
    private App app;
    private StudentJavaFX student;
    private boolean okClicked = false;
    
    public void setApp(App app) {
        this.app = app;
    }
    
    //Constructor
    public ControladorCuotas(){}
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void initialize(){
    }
    
    public void setStudent(StudentJavaFX student){
        this.student = student;
        
        txtNombre.setText(student.getNombre());
        txtApPat.setText(student.getAppat());
        txtApMat.setText(student.getApmat());
        txtFecha.setText(student.getFecha());
        txtGrado.setText("Aun no asignado");
        //txtGenero.setText(student.getGenero());
        txtSeccion.setText("Aun no asignado");
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    // Funcion boton reporte
    @FXML
    private void handleReporte(){
        dialogStage.close();
    }
    
    // Funcion boton volver
    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}
