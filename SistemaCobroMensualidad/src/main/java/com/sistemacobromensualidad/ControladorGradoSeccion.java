package com.sistemacobromensualidad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import com.sistemacobromensualidad.App;
import javafx.scene.control.Alert;

public class ControladorGradoSeccion {
    
    @FXML
    private RadioButton Grado1,Grado2,Grado3,Grado4,Grado5,Grado6;
    @FXML
    private RadioButton SecciA,SecciB,SecciC,SecciD;
    
    private App app;
    private Stage dialogStage;
    
    private boolean okClicked = false;
    private int grado;
    private char seccion;
    
    // Constructor
    public ControladorGradoSeccion() {
    }
    
    @FXML
    private void initialize(){
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    public int getGrado() {
        if (Grado1.isSelected()) {
            return 1;
        } else if (Grado2.isSelected()) {
            return 2;
        } else if (Grado3.isSelected()) {
            return 3;
        } else if (Grado4.isSelected()) {
            return 4;
        } else if (Grado5.isSelected()) {
            return 5;
        } else if (Grado6.isSelected()) {
            return 6;
        } else {
            // Mostrar el mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Selección invalida");
            alert.setHeaderText("Por favor seleccione un grado.");

            alert.showAndWait();
            return 0;
        }
    }

    public char getSeccion() {
        if (SecciA.isSelected()) {
            return 'A';
        } else if (SecciB.isSelected()) {
            return 'B';
        } else if (SecciC.isSelected()) {
            return 'C';
        } else if (SecciD.isSelected()) {
            return 'D';
        } else {
            // Mostrar el mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Selección invalida");
            alert.setHeaderText("Por favor seleccione una sección.");

            alert.showAndWait();
            return ' ';
        }
    }
    
    @FXML
    private void handleConfirmar() {
        
        /*grado = getGrado();
        seccion = getSeccion();
        dialogStage.close();
        app.showListaEstudiantes(grado,seccion);*/
    }

    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}
