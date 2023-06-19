package com.sistemacobromensualidad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Sistema de cobro de mensualidades");
        
        initRootLayout();
        showMenuPrincipal();
    }
    
    public void initRootLayout() {
        try {
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

    public void showMenuPrincipal(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuPrincipal.fxml"));
            AnchorPane menuPrincipal = (AnchorPane) loader.load();
        
            rootLayout.setCenter(menuPrincipal);
            
            ControladorMenuPrincipal controlador = loader.getController();
            controlador.setApp(this);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
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
            /*ControladorGradoSeccion controller = loader.getController();
            controller.setDialogStage(dialogStage);*/
            
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
        }catch(IOException e){
            e.printStackTrace();
        
        }
    }
    
    public boolean showMatricula(){
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
            /*ControladorGradoSeccion controller = loader.getController();
            controller.setDialogStage(dialogStage);
            */
            //Mostrar hasta que se cierre la ventana
            dialogStage.showAndWait();
            
            //return controller.isOkClicked();
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //para mostrar la ventana de cuotas
    public boolean showCuotas(){
        try {
            // Cargar el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Cuotas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
        
            // Crear la ventana ejecutable
            Stage dialogStage = new Stage();
            dialogStage.setTitle("VISTA DE DATOS Y CUOTAS");
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
    
    public static void main(String[] args) {
        launch(args);
    }

}