package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.Student;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorListaEstudiantes {
    @FXML
    private TableView<Student> studentTabla;
    @FXML
    private TableColumn<Student, String> nombreColumna;
    @FXML
    private TableColumn<Student, String> appatColumna;
    @FXML
    private TableColumn<Student, String> apmatColumna;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellido;
    @FXML
    private Label lblFecha;
    @FXML
    private Label lblGrado;
    @FXML
    private Label lblGenero;
    
    
    //Constructor
    public ControladorListaEstudiantes(){}

    private Stage dialogStage;
    //private boolean okClicked = false;
    
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
    private void handleVerCuotas() {
        //app.showGradoSeccion();
        app.showCuotas();
    }
    
    @FXML
    private void handleRegistrarPago(){
        app.showRegistrarPago();
    }
    
    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}