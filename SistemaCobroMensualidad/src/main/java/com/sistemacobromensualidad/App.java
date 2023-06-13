package com.sistemacobromensualidad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
    
        /*scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();*/
        
        initRootLayout();
        
    }
    
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/com.sistemacobromensualidad.view/rootLayout.fxml"));
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
            loader.setLocation(App.class.getResource("/com.sistemacobromensualidad.view/MenuPrincipal.fxml"));
            AnchorPane menuPrincipal = (AnchorPane) loader.load();
        
            rootLayout.setCenter(menuPrincipal);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}