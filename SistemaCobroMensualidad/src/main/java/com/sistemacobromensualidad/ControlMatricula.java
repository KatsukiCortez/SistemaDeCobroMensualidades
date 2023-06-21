package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControlMatricula {
    @FXML
    private TableView<StudentJavaFX> studentTable;
    @FXML
    private TableColumn<StudentJavaFX, Integer> DccColum;
    @FXML
    private TableColumn<StudentJavaFX, String> NomColum;
    @FXML
    private TableColumn<StudentJavaFX, String> AppatColum;
    @FXML
    private TableColumn<StudentJavaFX, String> ApmatColum;
    @FXML
    private TableColumn<StudentJavaFX, String> FechatColum;
    @FXML
    private TableColumn<StudentJavaFX, String> DireColum;
    @FXML
    private TableColumn<StudentJavaFX, Integer> TeleColum;
    
    @FXML
    private TextField tfdoc;
    @FXML
    private TextField tfappat;
    @FXML
    private TextField tfapmat;
    @FXML
    private TextField tftele;
    @FXML
    private TextField tfnombre;
    @FXML
    private TextField tfdire;
    @FXML
    private TextField tffecha;
    
    private StudentJavaFX student;
    private Stage dialogStage;
    
    /**
     * Inicializa la clase control.
     * Este metodo es automaticamente llamado despues de que el fxml haya sido iniciado
     */
    @FXML
    private void initialize(){
    }
    
    /**
     * Guarda el escenario en dialogStage
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    /**
     * Guarda student para ser editado en dialog
     * 
     * @param student
     */
    public void setStudent(StudentJavaFX student){
        this.student = student;
        
        tfdoc.setText(Integer.toString(student.getDocumento()));
        tfnombre.setText(student.getNombre());
        tfappat.setText(student.getAppat());
        tfapmat.setText(student.getApmat());
        tffecha.setText(student.getFecha());
        tfdire.setText(student.getDireccion());
        tftele.setText(Integer.toString(student.getTelefono()));
    }
}
