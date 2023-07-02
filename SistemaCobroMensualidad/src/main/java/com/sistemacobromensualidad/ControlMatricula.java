package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import com.sistemacobromensualidad.persistencia.EstudiantePersistencia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class ControlMatricula {
    @FXML
    private TableView<StudentJavaFX> studentTable;
    @FXML
    private TableColumn<StudentJavaFX, Integer> DniColum;
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
    private TextField tfdni;
    @FXML
    private TextField tfnombre;
    @FXML
    private TextField tfappat;
    @FXML
    private TextField tfapmat;
    @FXML
    private DatePicker dpfecha;
    @FXML
    private TextField tfdireccion;
    @FXML
    private ChoiceBox<Integer> Grado; 
    private Integer[] grado = {1,2,3,4,5,6};
    
    @FXML
    private RadioButton Femenino,Masculino;
    @FXML
    private ChoiceBox<String> Seccion;
    private String[] seccion = {"A","B","C","D"}; 
    
    
    private StudentJavaFX student;
    private EstudiantePersistencia studentpersis;
    private Stage dialogStage;
    private boolean okClicked = false;
    private App app;
    
    /**
     * Inicializa la clase control.
     * Este metodo es automaticamente llamado despues de que el fxml haya sido iniciado
     */
    @FXML
    private void initialize(){
        Grado.getItems().addAll(grado);
        Grado.setOnAction(this::getGrado);
        Seccion.getItems().addAll(seccion);
        //Seccion.setOnAction(this::getSeccion);
    }
    
    /**
     * Guarda el escenario en dialogStage
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    public void setApp(App app) {
        this.app = app;
    }
    
    /**
     * Guarda student para ser editado en dialog
     * 
     * @param student
     */
    public void setStudent(StudentJavaFX student){
        this.student = student;
        tfdni.setText(Integer.toString(student.getDocumento()));
        tfnombre.setText(student.getNombre());
        tfappat.setText(student.getAppat());
        tfapmat.setText(student.getApmat());
    }
    
    public void getGrado(ActionEvent event) {
        Integer mygrado = Grado.getValue();
    }

    public char getSeccion() {
        String myseccion = Seccion.getValue();
        return myseccion.charAt(0);
    }
    
    public Integer getGenero(){
        Integer genero = 1;
        if(Femenino.isSelected()){
            genero = 1;
        }
        else if(Masculino.isSelected()){
            genero = 0;
        }
        return genero;
    }
    
    public String getDate(){
        LocalDate myDate = dpfecha.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));
        return myFormattedDate;
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
        tfdni.setText("");
        tfnombre.setText("");
        tfappat.setText("");
        tfapmat.setText("");
        
    }
    
    /**
     * Llamado cuando el usuario hace click en Nuevo
     */
    @FXML
    private void buttonNuevo(){
        Limpiador();
        /*String dni = tfdni.getText();
        String nombres = tfnombre.getText();
        String apellidoPaterno = tfappat.getText();
        String apellidoMaterno = tfapmat.getText();
        String fnacimiento = getDate();
        Integer grado = Grado.getValue();
        String direccion = tfdireccion.getText();
        Integer genero = getGenero();
        char seccion = getSeccion();
        
        studentpersis.setDni(dni);
        studentpersis.setNombres(nombres);
        studentpersis.setApellidoPaterno(apellidoPaterno);
        studentpersis.setApellidoMaterno(apellidoMaterno);;
        studentpersis.setFnacimiento(fnacimiento);
        studentpersis.setGrado(grado);
        studentpersis.setDireccion(direccion);
        studentpersis.setGenero(genero);
        studentpersis.setSeccion(seccion);
        studentpersis.InsertarEstudiante();*/
    }
    
    /**
     * Llamado cuando el usuario hace clik en guardar
     */
    @FXML
    private void buttonGuardar(){
        if(isInputValid()){
            /*student.setDocumento(Integer.parseInt(tfdoc.getText()));
            student.setNombre(tfnombre.getText());
            student.setAppat(tfappat.getText());
            student.setApmat(tfapmat.getText());
            student.setFecha(tffecha.getText());
            student.setDireccion(tfdire.getText());
            student.setTelefono(Integer.parseInt(tftele.getText()));
            
            okClicked = true;
            dialogStage.close();*/
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
        
        /*if(tfdni.getText() == null || tfdni.getText().length() == 0){
            errorMessage += "No es valido el Documento\n";
        }else{
            //Intenta analizar el documento en un entero
            try{
                Integer.parseInt(tfdni.getText());
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
        */
        return false;
    }
    
    
    
}
    
