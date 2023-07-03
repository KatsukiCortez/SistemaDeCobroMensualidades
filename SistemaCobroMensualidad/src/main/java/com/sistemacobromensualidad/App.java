// Esta es el menu Principal
package com.sistemacobromensualidad;
import com.sistemacobromensualidad.modelo.StudentJavaFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * JavaFX App VERSION ESTABLE
 */
// Extendemos la clase applicacion
public class App extends Application {
    // Definimos las Variables
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<StudentJavaFX> studentList = FXCollections.observableArrayList();
    
    public App(){
    }

    // Con esto se ejecutara el programa al inicio
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Sistema de cobro de mensualidades");
        
        //Agregar icono principal
        this.primaryStage.getIcons().add(new Image(App.class.getResourceAsStream("/img/principal.png")));
        
        // Hacemos la llamada a los metodos
        initRootLayout();
        showlog(user, contra);
        //showMenuPrincipal();
    }
    // Implementamos el metodo initRootLayout y cargamos el diceño principal
    // de la interfaz grafica
    public void initRootLayout() {
        try {
            // Establecemos la Ubicacion
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Implementamos el metodo showMenuPrincipal para cargar el contenido del
    // Menú principal dentro de la interfaz anterior
    public void showMenuPrincipal(){
        try{
            // Establecemos la Ubicacion
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/MenuPrincipal.fxml"));
            AnchorPane menuPrincipal = (AnchorPane) loader.load();
            
            // Establecemos como Interfaz Central
            rootLayout.setCenter(menuPrincipal);
            
            ControladorMenuPrincipal controlador = loader.getController();
            controlador.setApp(this);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public void showlog(String user, String contra){
        try{
            // Establecemos la Ubicacion
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/Loging.fxml"));
            AnchorPane menuPrincipal = (AnchorPane) loader.load();
            
            // Establecemos como Interfaz Central
            rootLayout.setCenter(menuPrincipal);
            
            ControladorMenuPrincipal controlador = loader.getController();
            controlador.setApp(this);
            
            ResultSet rs;
        if (user.equals("") && contra.equals("")){
            Alert dialog=new Alert(Alert.AlertType.INFORMATION);// crea un tipode dialogo de alerta simple
            dialog.setTitle("MENSAJE");
            dialog.setHeaderText(null);//Sin titulo interno
            dialog.setContentText("Falta completar datos en un campo");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.showAndWait();
        }
        else{
            String url = "jdbc:mysql://localhost:3306/cobros";
            String usuario = "root";
            String contraseña = "";
            try{
                Connection connection = DriverManager.getConnection(url, usuario, contraseña);
                
                PreparedStatement pst = connection.prepareStatement("select * from usuarios where id_usuario=? and usuario=?");
                pst.setString(1, user);
                pst.setString(2, contra);
                
                rs = pst.executeQuery();
                if(rs.next()){
                    Alert dialog=new Alert(Alert.AlertType.INFORMATION);// crea un tipode dialogo de alerta simple
                    dialog.setTitle("MENSAJE");
                    dialog.setHeaderText(null);//Sin titulo interno
                    dialog.setContentText("Ingreso exitoso");
                    dialog.initStyle(StageStyle.UTILITY);
                    dialog.showAndWait();
                    
                    showMenuPrincipal();
                }else{
                    Alert dialog=new Alert(Alert.AlertType.INFORMATION);// crea un tipode dialogo de alerta simple
                    dialog.setTitle("MENSAJE");
                    dialog.setHeaderText(null);//Sin titulo interno
                    dialog.setContentText("Ingreso Fallido, intente nuevamente");
                    dialog.initStyle(StageStyle.UTILITY);
                    dialog.showAndWait();
                }
            }catch(SQLException e){
                System.out.println("error en la conección"+e);
            }
        }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    // Implementamos el metodo showGradoSeccion donde cargaremos el FXML GradiSeccion
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Stage
    // hazta que se cierre
    public void showReport(){
        String url = "jdbc:mysql://localhost:3306/cobros";
        String usuario = "root";
        String contraseña = "";
        try{  
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            try{
            JasperReport jasperReport = null;
            JasperPrint jasperPrint = null;
            JasperDesign jasperDesign = null;            
            jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/fxml/Reporte.jrxml"));
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, null,connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint,"reportesListaPersonas.pdf");
            JasperViewer view=new JasperViewer(jasperPrint,false);
            //view.setDefaultCloseOperation(1);
            view.setVisible(true);
            
            } catch (Exception ex){
                System.out.println("EXCEPTION: "+ ex);
            }
        }catch(SQLException e){
            System.out.println("error en la conección"+e);
        }
    }
    // Implementamos el metodo showListaEstudiantes donde cargaremos el FXML ListaEstudiantes
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Stage
    // hazta que se cierre
    public void showListaEstudiantes(int grado, char seccion){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/ListaEstudiantes.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Lista de estudiantes");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Usar el controlador
            ControladorListaEstudiantes controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setApp(this);
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
        }catch(IOException e){
            // Atrapamos los Errores
            e.printStackTrace();
        
        }
    }
    // Implementamos el metodo showMatricula donde cargaremos el FXML ListaEstudiantes
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Matricula
    // hazta que se cierre
    public void showMatricula(/*StudentJavaFX student*/){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/Matricula.fxml"));
                        
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Matricula");
            // Poner icono a la ventana ejecutada.
            dialogStage.getIcons().add(new Image(App.class.getResourceAsStream("/img/matricula.png")));
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Usar el controlador
            ControlMatricula controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setApp(this);

            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
            //return controller.isOkClicked();
            
        }catch(IOException e){
            e.printStackTrace();
            
        }
    }
    // Implementamos el metodo showCuotas donde cargaremos el FXML ListaEstudiantes
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Cuotas
    // hazta que se cierre
    public boolean showCuotas(StudentJavaFX student){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/Cuotas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Detalles de alumnos.");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Usar el controlador
            ControladorCuotas controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setApp(this);
            controller.setStudent(student);
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void showRegistrarPago(StudentJavaFX student){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/RegistrarPago.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Registrar Pago");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Usar el controlador
            ControladorRegistrarPago controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setApp(this);
            controller.setStudent(student);
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
