// Esta es el menu Principal
package com.sistemacobromensualidad;
// Importamos las librerias y dependencias
import com.sistemacobromensualidad.ControlMatricula;
import com.sistemacobromensualidad.modelo.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;


import java.util.HashMap;
import java.util.Map;

//JASPER
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
    // Datos tontos
    private ObservableList<Student> studentData = FXCollections.observableArrayList();
    public App(){
        // Agregando datos
        studentData.add(new Student("Jose Luis","Ramirez","Huanca"));
        studentData.add(new Student("Jose Alberto","Castillo","Rodriguez"));
        studentData.add(new Student("Paco","Maram","Lindsey"));
        studentData.add(new Student("Roberto","Alvez","Garcia"));
        studentData.add(new Student("Edward","Roque","Pena"));
        studentData.add(new Student("Javier Nilson","De la cruz","Tintaya"));
    }
    
    public ObservableList<Student> getStudenData(){
        return studentData;
    }

    
    private static Scene scene;
    
    // Con esto se ejecutara el programa al inicio
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Sistema de cobro de mensualidades");
        // Hacemos la llamada a los metodos
        initRootLayout();
        showMenuPrincipal();
    }
    // Implementamos el metodo initRootLayout y cargamos el diceño principal
    // de la interfaz grafica
    public void initRootLayout() {
        try {
            // Establecemos la Ubicacion
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("rootLayout.fxml"));
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
            loader.setLocation(App.class.getResource("MenuPrincipal.fxml"));
            AnchorPane menuPrincipal = (AnchorPane) loader.load();
            
            // Establecemos como Interfaz Central
            rootLayout.setCenter(menuPrincipal);
            
            ControladorMenuPrincipal controlador = loader.getController();
            controlador.setApp(this);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    // Implementamos el metodo showGradoSeccion donde cargaremos el FXML GradiSeccion
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Stage
    // hazta que se cierre
    public boolean showGradoSeccion(){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GradoSeccion.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Grado y seccion");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Usar el controlador
            ControladorGradoSeccion controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setApp(this);
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
            //return controller.isOkClicked();
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    // Implementamos el metodo showListaEstudiantes donde cargaremos el FXML ListaEstudiantes
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Stage
    // hazta que se cierre
    public void showListaEstudiantes(int grado, char seccion){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("ListaEstudiantes.fxml"));
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
    public boolean showMatricula(/*Student student*/){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Matricula.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Matricula");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Usar el controlador
            ControlMatricula controller = loader.getController();
            //controller.setDialogStage(dialogStage);
            //controller.setApp(this);*/

            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
            //return controller.isOkClicked();
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    // Implementamos el metodo showCuotas donde cargaremos el FXML ListaEstudiantes
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Cuotas
    // hazta que se cierre
    public void showCuotas(){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Cuotas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("XXXX");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Usar el controlador
            ControladorCuotas controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setApp(this);
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void showRegistrarPago(){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("RegistrarPago.fxml"));
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
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void showReport(){
        try{
            JasperReport jasperReport = null;
            JasperPrint jasperPrint = null;
            JasperDesign jasperDesign = null;
            Map parameters = new HashMap();
            jasperDesign = JRXmlLoader.load("Reporte.jrxml");
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,new JRBeanCollectionDataSource(getStudenData()));
            JasperExportManager.exportReportToPdfFile(jasperPrint,"ListaPersonas.pdf");
            JasperViewer.viewReport(jasperPrint);
            
        } catch (Exception ex){
            System.out.println("EXCEPTION: "+ ex);
        }
    }

    
    // Implementamos el Metodo Main de la clase App el cual se usara para iniciar la
    // Aplicacion JavaFX 
    public static void main(String[] args) {
        // Iniciamos la Aplicacion JAVA FX
        launch(args);
    }

}