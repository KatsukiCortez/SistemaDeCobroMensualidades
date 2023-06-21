package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.Student;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControlMatricula {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> DccColum;
    @FXML
    private TableColumn<Student, String> NomColum;
    @FXML
    private TableColumn<Student, String> AppatColum;
    @FXML
    private TableColumn<Student, String> ApmatColum;
    @FXML
    private TableColumn<Student, String> FechatColum;
    @FXML
    private TableColumn<Student, String> DireColum;
    @FXML
    private TableColumn<Student, Integer> TeleColum;
    
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
    
    private Student student;
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
    public void setStudent(Student student){
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
