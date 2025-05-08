package org.icesi.javafx.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.icesi.javafx.HelloApplication;
import org.icesi.javafx.model.Teacher;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Stage stage;

    private SchoolController school;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @FXML
    private CheckBox checkBoxStudent;

    @FXML
    private CheckBox checkBoxTeacher;

    @FXML
    private Button backButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        school = SchoolController.getInstance();
    }

   @FXML
    public void onLoginButtonClick (){

       String username = usernameField.getText();
       String password = passwordField.getText();

       if(checkBoxTeacher.isSelected() && !checkBoxStudent.isSelected()){
           for (Teacher teacher : school.getTeachers()) {

               if (username.equals(teacher.getName()) && password.equals(teacher.getPassword())) {
                   errorLabel.setText("Login successful for " + username);
                   school.currentCourse(teacher.getSubject());


                     stage = (Stage) loginButton.getScene().getWindow();
                     HelloApplication.onWindowOpen("classrom-view.fxml", stage);
                   return;
               }else {
                   errorLabel.setText("Invalid username or password.");
               }
           }
       }else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Error");
              alert.setHeaderText("Login Error");
                alert.setContentText("No se pueden logear los estudiantes");
              alert.show();
       }
    }
    @FXML
    protected void backClick(){
        stage = (Stage) backButton.getScene().getWindow();
        HelloApplication.onWindowOpen("reception-view.fxml",stage);
    }

}
