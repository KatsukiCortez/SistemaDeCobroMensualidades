package com.sistemacobromensualidad;

import com.sistemacobromensualidad.modelo.StudentJavaFX;
import com.sistemacobromensualidad.persistencia.EstudiantePersistencia;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableColumn<StudentJavaFX, String> DniColum;
    @FXML
    private TableColumn<StudentJavaFX, String> NomColum;
    @FXML
    private TableColumn<StudentJavaFX, String> AppatColum;
    @FXML
    private TableColumn<StudentJavaFX, String> ApmatColum;
    @FXML
    private TableColumn<StudentJavaFX, String> FechaColum;
    @FXML
    private TableColumn<StudentJavaFX, String> DireColum;
    @FXML
    private TableColumn<StudentJavaFX, Integer> GradoColum;
    @FXML
    private TableColumn<StudentJavaFX, String> SeccionColum;
    
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
        
        studentTable.getSelectionModel().selectedItemProperty().addListener
        ((observable, oldValue, newValue) -> showDetallesEstudiante(newValue));
        
        studentTable.setItems(getData());
        LimpiarTabla();
    }
    
    private StudentJavaFX student;
    private Stage dialogStage;
    private boolean okClicked = false;
    private App app;
    
    private void LimpiarTabla(){
        studentTable.getItems().clear();
    }
    
    private ObservableList<StudentJavaFX> studentList = FXCollections.observableArrayList();
    
    private ObservableList<StudentJavaFX> getData(){
        String url = "jdbc:mysql://localhost:3306/cobros";
        String usuario = "root";
        String contraseña = "";
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "SELECT dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, grado, direccion, genero, seccion FROM estudiante";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            String dni = resultSet.getString("dni");
            String nombres = resultSet.getString("nombres");
            String apellidoPaterno = resultSet.getString("apellidoPaterno");
            String apellidoMaterno = resultSet.getString("apellidoMaterno");
            String fnacimiento = resultSet.getString("fnacimiento");
            int grado = resultSet.getInt("grado");
            String direccion = resultSet.getString("direccion");
            int genero = resultSet.getInt("genero");
            String seccion = resultSet.getString("seccion");
            
            StudentJavaFX estudiante = new StudentJavaFX(dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, direccion, genero, grado, String.valueOf(seccion));
            studentList.add(estudiante);
            return studentList;
        }
        } catch (SQLException ex){
            System.out.println("Error: "+ ex);
        }
        return studentList;
    }
    
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    public void setApp(App app) {
        this.app = app;
    }
    
    public void setStudent(StudentJavaFX student){
        this.student = student;
    }
    
    public int getGrado() {
        Integer mygrado = cbGrado.getValue();
        return mygrado;
    }

    public char getSeccion() {
        String myseccion = cbSeccion.getValue();
        return myseccion.charAt(0);
    }
    
    public int getGenero(){
        Integer genero = 0;
        if(Femenino.isSelected()){
            genero = 0;
        }
        else if(Masculino.isSelected()){
            genero = 1;
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
        dateFecha.setValue(null);
        cbGrado.valueProperty().set(null);
        cbSeccion.valueProperty().set(null);
    }
    
    public void showDetallesEstudiante(StudentJavaFX estudiante){
        if(estudiante != null){
            txtDni.setText(estudiante.getDni());
            txtNombres.setText(estudiante.getNombre());
            txtApPaterno.setText(estudiante.getAppat());
            txtApMaterno.setText(estudiante.getApmat());
            txtDireccion.setText(estudiante.getDireccion());
            // Obtener lista para estudiante
            String fechaString = estudiante.getFecha(); 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaLocalDate = LocalDate.parse(fechaString, formatter);

            dateFecha.setValue(fechaLocalDate);
            cbGrado.valueProperty().set(estudiante.getGrado());
            cbSeccion.valueProperty().set(estudiante.getSeccion());
        } else {
            Limpiador();
        }
    }
    
    @FXML
    private void btnRefresh(){
        LimpiarTabla();
        String url = "jdbc:mysql://localhost:3306/cobros";
        String usuario = "root";
        String contraseña = "";
        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "SELECT dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, grado, direccion, genero, seccion FROM estudiante";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            String dni = resultSet.getString("dni");
            String nombres = resultSet.getString("nombres");
            String apellidoPaterno = resultSet.getString("apellidoPaterno");
            String apellidoMaterno = resultSet.getString("apellidoMaterno");
            String fnacimiento = resultSet.getString("fnacimiento");
            int grado = resultSet.getInt("grado");
            String direccion = resultSet.getString("direccion");
            int genero = resultSet.getInt("genero");
            String seccion = resultSet.getString("seccion");
            
            StudentJavaFX estudiante = new StudentJavaFX(dni, nombres, apellidoPaterno, apellidoMaterno, fnacimiento, direccion, genero, grado, String.valueOf(seccion));
            studentList.add(estudiante);
        }
        } catch (SQLException ex){
            System.out.println("Error: "+ ex);
        }
        
        
        DniColum.setCellValueFactory(cellData -> cellData.getValue().dniProperty());
        NomColum.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        AppatColum.setCellValueFactory(cellData -> cellData.getValue().appatProperty());
        ApmatColum.setCellValueFactory(cellData -> cellData.getValue().apmatProperty());
        FechaColum.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        DireColum.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        GradoColum.setCellValueFactory(cellData -> cellData.getValue().gradoProperty().asObject());
        SeccionColum.setCellValueFactory(cellData -> cellData.getValue().seccionProperty());
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
            EstudiantePersistencia studentpersis = new EstudiantePersistencia();
            
            String dni = txtDni.getText();
            String nombres = txtNombres.getText();
            String apellidoPaterno = txtApPaterno.getText();
            String apellidoMaterno = txtApMaterno.getText();
            String fnacimiento = getDate();
            String grado = String.valueOf(cbGrado.getValue());
            String direccion = txtDireccion.getText();
            String genero = String.valueOf(getGenero());
            String seccion = String.valueOf(getSeccion());
            
            studentpersis.setDni(dni);
            studentpersis.setNombres(nombres);
            studentpersis.setApellidoPaterno(apellidoPaterno);
            studentpersis.setApellidoMaterno(apellidoMaterno);;
            studentpersis.setFnacimiento(fnacimiento);
            studentpersis.setGrado(getGrado());
            studentpersis.setDireccion(direccion);
            studentpersis.setGenero(getGenero());
            studentpersis.setSeccion(getSeccion());
            boolean error = studentpersis.InsertarEstudiante();
            if(error){
                Alert exito = new Alert(Alert.AlertType.INFORMATION);
                exito.initOwner(dialogStage);
                exito.setTitle("Informacion correcta");
                exito.setHeaderText("Estudiante matriculado correctamente");
            
                exito.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Error!");
                alert.setHeaderText("Estudiante no registrado");
                alert.setContentText("Estudiante duplicado o campos vacios.");
                
                alert.showAndWait();
            }
        Limpiador();
        }
    }
    
    @FXML
    private void buttonCancel(){
        dialogStage.close();
    }
    
    @FXML
    private void buttonPagar(){
        StudentJavaFX selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if(selectedStudent != null){
            app.showRegistrarPago(selectedStudent);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleccion invalida");
            alert.setHeaderText("Ningun estudiante seleccionado.");
            alert.showAndWait();
        }
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
        if(txtNombres.getText() == null || txtNombres.getText().length() == 0){
            errorMessage += "No es valido el Nombre\n";
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
        if(dateFecha.getValue() == null){
            errorMessage += "No es valida la Fecha de Nacimiento\n";
        }
        if(cbGrado.getValue() == null){
            errorMessage += "No es valido el Grado\n";
        }
        if(cbSeccion.getValue() == null){
            errorMessage += "No es valida la Sección\n";
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
    
