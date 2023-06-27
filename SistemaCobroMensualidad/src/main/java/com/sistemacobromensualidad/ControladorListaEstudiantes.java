package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorListaEstudiantes {
    @FXML
    private TableView<StudentJavaFX> studentTabla;
    @FXML
    private TableColumn<StudentJavaFX, String> nombreColumna;
    @FXML
    private TableColumn<StudentJavaFX, String> appatColumna;
    
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
    
    //Referenciar la aplicacion principal
    private App app;

    //Constructor
    public ControladorListaEstudiantes(){}

    //Este fxml sera una cuadro de dialogo
    private Stage dialogStage;
    
    /*Iniciar controlador, este metodo sera ejecutado despues de
    que el FXML sea cargado
    */
    @FXML
    private void initialize(){
        nombreColumna.setCellValueFactory(
                cellData -> cellData.getValue().NombreProperty());
        appatColumna.setCellValueFactory(
                cellData -> cellData.getValue().AppatProperty());
        
        // Limpiar datos al inicio
        showStudentDetails(null);
        
        // Mostrar datos de seleccion en columna nombre o apellido
        studentTabla.getSelectionModel().selectedItemProperty().addListener
        ((observable,oldValue, newValue)-> showStudentDetails(newValue));
    }
    
    public void setApp(App app) {
        this.app = app;
        
        //Agregar la lista observable a la tabla
        studentTabla.setItems(app.getStudenData());
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    // MostrarDatos de los estudiantes
    private void showStudentDetails(StudentJavaFX student){
        if(student != null){
            lblNombre.setText(student.getNombre());
            lblApPat.setText(student.getAppat());
            lblApMat.setText(student.getApmat());
            lblFecha.setText(student.getFecha());
            lblGrado.setText("Aun no asignado");
            lblGenero.setText("Humanos");
        } else {
            lblNombre.setText("");
            lblApPat.setText("");
            lblApMat.setText("");
            lblFecha.setText("");
            lblGrado.setText("");
            lblGenero.setText("");
        }
    }
    
    
    // Boton ver cuotas
    @FXML
    private void handleVerCuotas() {
        app.showCuotas();
    }
    
    // Boton registrar pago
    @FXML
    private void handleRegistrarPago(){
        app.showRegistrarPago();
    }
    
    // Boton volver
    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}