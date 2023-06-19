
package com.sistemacobromensualidad;

import javafx.fxml.FXML;
import javafx.stage.Stage;
//import javafx.event.ActionEvent;


public class ControladorCuotas {

    public ControladorCuotas() {
    }
    private App app;
    private Stage dialogStage;
    public void setApp(App app) {
        this.app = app;
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void handleVolver() {
        dialogStage.close();
    }
}
