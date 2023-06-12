package com.mycompany.sistemamatriculas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */

public class App extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage stage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de matriculas");
        
        initRootLayout();
    }
    
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/view/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void MenuPrincipal(){
        // Cargar menu principal
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(App)
    }

    public static void main(String[] args) {
        launch();
    }

}








/*public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}*/