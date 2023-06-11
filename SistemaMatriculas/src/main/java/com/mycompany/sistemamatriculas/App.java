package com.mycompany.sistemamatriculas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;



/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage stage) {
        /*var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();*/
        
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de matriculas");
        
        initRootLLayout();
    }
    
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/view/rootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}


/*

public class App extends Application {
    
    private Stage primaryStage;
    private BorderPane rutaraiz;

    public void initRutaRaiz(){
        try{
            // Declarar e iniciar la ruta raiz
            FXMLLoader loader = new FXMLLoader;
        }catch()
    }
    
    @Override
    public void start(Stage stage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de matriculas");
        
    }

    public static void main(String[] args) {
        launch();
    }

}

*/