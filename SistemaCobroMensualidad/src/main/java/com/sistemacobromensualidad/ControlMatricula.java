package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
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
    
    /**
     * Retorna trues si el ususario hace click, caso contrario es falso
     * 
     * @return
     */
    public boolean isOkClicked(){
        return okClicked;
    }
    
    /**
     * Para poder limpiar los campos de texto
     */
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
     * Llamado cuando el usuario hace click en Nuevo
     */
    @FXML
    private void buttonNuevo(){
        Limpiador();
    }
    
    /**
     * Llamado cuando el usuario hace clik en guardar
     */
    @FXML
    private void buttonGuardar(){
        if(isInputValid()){
            student.setDocumento(Integer.parseInt(tfdoc.getText()));
            student.setNombre(tfnombre.getText());
            student.setAppat(tfappat.getText());
            student.setApmat(tfapmat.getText());
            student.setFecha(tffecha.getText());
            student.setDireccion(tfdire.getText());
            student.setTelefono(Integer.parseInt(tftele.getText()));
            
            okClicked = true;
            dialogStage.close();
        }
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
        }else{
            //Intenta analizar el Telefono en un entero
            try{
                Integer.parseInt(tftele.getText());
            }catch(NumberFormatException e){
                errorMessage += "No es valido el Telefono (Debe ser un numero entero)!\n";
            }
        }
        
        if (errorMessage.length() == 0){
            return true;
        } else {
            //Muestra el mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos no Validos");
            alert.setHeaderText("Por fvor corrija los campos de texto no validos");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            return false;
        }
    }
    
}
    
