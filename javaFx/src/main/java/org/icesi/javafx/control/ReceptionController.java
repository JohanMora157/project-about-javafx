package org.icesi.javafx.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.icesi.javafx.HelloApplication;

public class ReceptionController {

    private Stage stage;

    @FXML
    private Button toLoginButton;

    @FXML
    private Button toRegisterButton;

    @FXML
    private Button exitButton;

    @FXML
    protected void goToLogin(){
        stage = (Stage) toLoginButton.getScene().getWindow();
        HelloApplication.onWindowOpen("login-view.fxml",stage);

    }

    @FXML
    protected void goToRegister() {
        stage = (Stage) toRegisterButton.getScene().getWindow();
        HelloApplication.onWindowOpen("hello-view.fxml",stage);
    }

    @FXML
    protected void exit() {
        stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }




}
