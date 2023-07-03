package com.sistemacobromensualidad;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class ControladorRegistrarPago {
    
    @FXML
    private Label Lnombre;
    @FXML
    private Label Lappat;
    @FXML
    private Label Lapmat;
    @FXML
    private Label Lgrado;
    @FXML
    private Label Lseccion;
    
    @FXML
    private RadioButton RBmatricula;
    @FXML
    private RadioButton RBpension;




    //Constructor
    public ControladorRegistrarPago(){}

    private Stage dialogStage;
    private boolean okClicked = false;
    
    //Referenciar la aplicacion principal
    private App app;

    public void setApp(App app) {
        this.app = app;
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void initialize(){
    }
    
    @FXML
    private void handleVolver(){
        dialogStage.close();
    }
}
