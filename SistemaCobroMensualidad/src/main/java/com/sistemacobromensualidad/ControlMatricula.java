package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.Student;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
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
    
    @FXML
    private RadioButton rbfem;
    @FXML
    private RadioButton rbmas;
    
    private Student student;
    private Stage dialogStage;
    private boolean okClicked = false;
    
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
    
    /**
     * Retorna trues si el ususario hace click, caso contrario es falso
     * 
     * @return
     */
    public boolean isOkClicked(){
        return okClicked;
    }
    
    public void Limpiador(){
        tfdoc.setText("");
        tfnombre.setText("");
        tfappat.setText("");
        tfapmat.setText("");
        tffecha.setText("");
        tfdire.setText("");
        tftele.setText("");
    }
    
    
    /**
     * Llama cuando el usuario hace click en cancel
     */
    @FXML
    private void buttonCancel(){
        dialogStage.close();
    }
    
    /**
     * Valida cuando el usuario ingresa en los campos de texto.
     * 
     * @return retorna verdadero si el ingreso en verdadero
     */
    private boolean isInputValid(){
        String errorMessage = "";
        
        if(tfdoc.getText() == null || tfdoc.getText().length() == 0){
            errorMessage += "No es valido el Documento\n";
        }else{
            //Intenta analizar el documento en un entero
            try{
                Integer.parseInt(tfdoc.getText());
            }catch(NumberFormatException e){
                errorMessage += "No es valido el Documento, (Debe ser numero entero)!\n";
            }
        }
        if(tfappat.getText() == null || tfappat.getText().length() == 0){
            errorMessage += "No es valido el Apellido Paterno\n";
        }
        if(tfapmat.getText() == null || tfapmat.getText().length() == 0){
            errorMessage += "No es valido el Apellido Materno\n";
        }
        if(tffecha.getText() == null || tfdoc.getText().length() == 0){
            errorMessage += "No es valido la fecha de nacimiento\n";
        }
        if(tfdire.getText() == null || tfdire.getText().length() == 0){
            errorMessage += "No es valido la Direccion\n";
        }
        if(tfnombre.getText() == null || tfnombre.getText().length() == 0){
            errorMessage += "No es valido el Nombre\n";
        }
        if(tftele.getText() == null || tftele.getText().length() == 0){
            errorMessage += "No es valido el telefono\n";
    }
    
}
