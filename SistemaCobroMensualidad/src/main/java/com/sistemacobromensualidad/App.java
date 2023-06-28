// Esta es el menu Principal
package com.sistemacobromensualidad;
// Importamos las librerias y dependencias
//import com.openjpa.OpenJPA;
// import com.sistemacobromensualidad.control.EstudianteControl;
import com.sistemacobromensualidad.control.exceptions.EntidadPreexistenteException;
import com.sistemacobromensualidad.entidades.Estudiante;
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

/*import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.List;
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
    //private ObservableList<StudentJavaFX> studentData = FXCollections.observableArrayList();
    
    public static Collection<StudentJavaFX> getStudenData(){
        // Agregando datos
        List<StudentJavaFX> studentData = new LinkedList<>();
        studentData.add(new StudentJavaFX("Jose Luis","Ramirez","Huanca"));
        studentData.add(new StudentJavaFX("Jose Alberto","Castillo","Rodriguez"));
        studentData.add(new StudentJavaFX("Paco","Maram","Lindsey"));
        studentData.add(new StudentJavaFX("Roberto","Alvez","Garcia"));
        studentData.add(new StudentJavaFX("Edward","Roque","Pena"));
        studentData.add(new StudentJavaFX("Javier Nilson","De la cruz","Tintaya"));
        studentData.add(new StudentJavaFX("Jose Luis","Ramirez","Huanca"));
        studentData.add(new StudentJavaFX("Jose Alberto","Castillo","Rodriguez"));
        studentData.add(new StudentJavaFX("Paco","Maram","Lindsey"));
        studentData.add(new StudentJavaFX("Roberto","Alvez","Garcia"));
        studentData.add(new StudentJavaFX("Edward","Roque","Pena"));
        studentData.add(new StudentJavaFX("Javier Nilson","De la cruz","Tintaya"));
        return studentData;
    }
    
    /*public ObservableList<StudentJavaFX> getStudenData(){
        return studentData;
    }*/

    // Con esto se ejecutara el programa al inicio
    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Sistema de cobro de mensualidades");
        
        //Agregar icono principal
        this.primaryStage.getIcons().add(new Image(App.class.getResourceAsStream("/img/matricula.png")));
        
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
    // Implementamos el metodo showGradoSeccion donde cargaremos el FXML GradiSeccion
    // y mostraremos el contenido, esto lo mostraremos en una nueva ventana Stage
    // hazta que se cierre
    public boolean showGradoSeccion(){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/GradoSeccion.fxml"));
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
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void showRegistrarPago(){
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
            jasperDesign = JRXmlLoader.load("C:\\Users\\estudiante\\REPOS\\SistemaDeCobroMensualidades\\SistemaCobroMensualidad\\src\\main\\resources\\fxml\\Reporte.jrxml");
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,new JRBeanCollectionDataSource(getStudenData()));
            JasperExportManager.exportReportToPdfFile(jasperPrint,"ListaPersonas.pdf");
            JasperViewer.viewReport(jasperPrint);
            
        } catch (Exception ex){
            System.out.println("EXCEPTION: "+ ex);
        }
    }
    
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    
    // Implementamos el Metodo Main de la clase App el cual se usara para iniciar la
    // Aplicacion JavaFX 
    
    /*
    static private String leerTexto(String mensaje) {
        String texto;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(mensaje);
            texto = in.readLine();
        } catch (IOException e) {
            texto = "Error";
        }
        return texto;
    }
    */
    
    public static void main(String[] args) {
        /*
        /*     CONTROL DE ERRORES 
        Estudiante estudiante;
        // Creamos la factoría de entity managers y un entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BaseDatos");
        
        EstudianteControl estudianteControl = new EstudianteControl(emf);
        
        // Pedimos datos del autor
        String documento = leerTexto("Introduce documento: ");
        String nombre = leerTexto("Introduce nombre: ");
        String apellidos = leerTexto("Introduce apellidos: ");
        String email = leerTexto("Introduce el correo electrónico: ");
        int doc = Integer.parseInt(documento);
        estudiante = new Estudiante(doc, nombre, apellidos, email);
        try {
            // Lo añadimos a la BD
            System.out.println("Documento del alumno: " + estudianteControl.insertar(estudiante));
        } catch (EntidadPreexistenteException ex) {
            Logger.getLogger(OpenJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("============================================");

        List<Estudiante> results = estudianteControl.buscaEstudiantes();
        for(Estudiante e : results){
            System.out.println(e);
        }
        
        System.out.println("============================================");
        // Marcamos el comienzo de la transacción
        */
        
        // Iniciamos la Aplicacion JAVA FX
        launch(args);
    }

}