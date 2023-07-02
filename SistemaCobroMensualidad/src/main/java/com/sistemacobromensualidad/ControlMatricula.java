package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import com.sistemacobromensualidad.persistencia.EstudiantePersistencia;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class ControlMatricula implements Initializable{
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
    private TextField txtDni;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApPaterno;
    @FXML
    private TextField txtApMaterno;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private TextField txtDireccion;
    @FXML
    private RadioButton Femenino,Masculino;
    @FXML
    private ChoiceBox<Integer> cbGrado; 
    private Integer[] grado = {1,2,3,4,5,6};
    
    @FXML
    private ChoiceBox<String> cbSeccion;
    private String[] seccion = {"A","B","C","D"}; 
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        cbGrado.getItems().addAll(grado);
        cbSeccion.getItems().addAll(seccion);
    }
    
    private StudentJavaFX student;
    private EstudiantePersistencia studentpersis;
    private Stage dialogStage;
    private boolean okClicked = false;
    private App app;
    
    @FXML
    public void initialize(){
        
    }
    
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    public void setApp(App app) {
        this.app = app;
    }
    
    public void setStudent(StudentJavaFX student){
        this.student = student;
        /*tfdni.setText(Integer.toString(student.getDocumento()));
        tfnombre.setText(student.getNombre());
        tfappat.setText(student.getAppat());
        tfapmat.setText(student.getApmat());*/
    }
    
    public void getGrado(ActionEvent event) {
        Integer mygrado = cbGrado.getValue();
    }

    public char getSeccion() {
        String myseccion = cbSeccion.getValue();
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
        LocalDate myDate = dateFecha.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return myFormattedDate;
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    public void Limpiador(){
        txtDni.setText("");
        txtNombres.setText("");
        txtApPaterno.setText("");
        txtApMaterno.setText("");
        txtDireccion.setText("");
    }
    
    @FXML
    private void buttonNuevo(){
        Limpiador();
    }
    
    /**
     * Llamado cuando el usuario hace clik en guardar
     */
    @FXML
    private void buttonGuardar() throws IOException{
        if(isInputValid()){
            String dni = txtDni.getText();
            String nombres = txtNombres.getText();
            String apellidoPaterno = txtApPaterno.getText();
            String apellidoMaterno = txtApMaterno.getText();
            String fnacimiento = getDate();
            String grado = String.valueOf(cbGrado.getValue());
            String direccion = txtDireccion.getText();
            //Integer genero = getGenero();
            String genero = String.valueOf(getGenero());
            //char seccion = getSeccion();
            String seccion = String.valueOf(getSeccion());

            String url = "jdbc:mysql://localhost:3306/cobros";
            String usuario = "root";
            String contraseña = "";
            //conexion 
            try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
                String sql = "INSERT INTO estudiante (dni, nombres, apellidoPaterno, apellidoMaterno ,fnacimiento, grado, direccion, genero, seccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, dni);
                    statement.setString(2, nombres);
                    statement.setString(3, apellidoPaterno);
                    statement.setString(4, apellidoMaterno);
                    statement.setString(5, fnacimiento);
                    statement.setString(6, String.valueOf(grado));
                    statement.setString(7, direccion);
                    statement.setString(8, String.valueOf(genero));
                    statement.setString(9, seccion);
                
                    int filasAfectadas = statement.executeUpdate();
                    if (filasAfectadas > 0) {
                        System.out.println("Los datos se han guardado correctamente en la base de datos.");
                    } else {
                        System.out.println("No se pudieron guardar los datos en la base de datos.");
                    }
                    
                }
            } catch (SQLException e) {
                System.out.println("No se pudo insertar en la base de datos.");
            }
            
            /*studentpersis.setDni(dni);
            studentpersis.setNombres(nombres);
            studentpersis.setApellidoPaterno(apellidoPaterno);
            studentpersis.setApellidoMaterno(apellidoMaterno);;
            studentpersis.setFnacimiento(fnacimiento);
            studentpersis.setGrado(grado);
            studentpersis.setDireccion(direccion);
            studentpersis.setGenero(genero);
            studentpersis.setSeccion(seccion);

            System.out.println(studentpersis.getDni());
            System.out.println(studentpersis.getNombres());
            System.out.println(studentpersis.getApellidoPaterno());
            System.out.println(studentpersis.getApellidoMaterno());
            System.out.println(studentpersis.getFnacimiento());
            System.out.println(studentpersis.getGrado());
            System.out.println(studentpersis.getSeccion());
            System.out.println(studentpersis.getGenero());
            System.out.println(studentpersis.getSeccion());*/
        }
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
    
    @FXML
    private void buttonCancel(){
        dialogStage.close();
    }
    
    private boolean isInputValid(){
        String errorMessage = "";
        
        if(txtDni.getText() == null || txtDni.getText().length() == 0){
            errorMessage += "No es valido el Documento\n";
        }else{
            //Intenta analizar el documento en un entero
            try{
                Integer.parseInt(txtDni.getText());
            }catch(NumberFormatException e){
                errorMessage += "No es valido el Documento, (Debe ser numero entero)!\n";
            }
        }
        if(txtApPaterno.getText() == null || txtApPaterno.getText().length() == 0){
            errorMessage += "No es valido el Apellido Paterno\n";
        }
        if(txtApMaterno.getText() == null || txtApMaterno.getText().length() == 0){
            errorMessage += "No es valido el Apellido Materno\n";
        }
        if(txtDireccion.getText() == null || txtDireccion.getText().length() == 0){
            errorMessage += "No es valido la Direccion\n";
        }
        
        if (errorMessage.length() == 0){
            return true;
        } else {
            //Muestra el mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos no Validos");
            alert.setHeaderText("Por favor corrija los campos de texto no validos");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            return false;
        }
    }
}
    
