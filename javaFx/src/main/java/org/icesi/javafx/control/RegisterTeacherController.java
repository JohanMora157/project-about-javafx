package org.icesi.javafx.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.icesi.javafx.HelloApplication;
import org.icesi.javafx.model.Course;
import org.icesi.javafx.model.Teacher;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterTeacherController implements Initializable {

    private Stage stage;

    private SchoolController school;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameTeacher;

    @FXML
    private TextField passwordTeacher;

    @FXML
    private ComboBox<String> subjectBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        school = SchoolController.getInstance();
        for (Course c : school.getCourses()) {
            if(c.getTeacher() == null){
                subjectBox.getItems().add(c.getName());
            }
        }
    }

    @FXML
    protected void registerTeacherClick(){
        String name = nameTeacher.getText();
        String password = passwordTeacher.getText();
        Course course = school.getCourse(subjectBox.getValue());

        Teacher teacher = new Teacher(name,subjectBox.getValue(),password);

        if(course.getTeacher() == null){
            course.setTeacher(teacher);
            teacher.setCourse(course);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Success registering teacher"+ name);
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error, teacher already registered, his name is: "+course.getTeacher().getName());
            alert.show();
        }
    }

    @FXML
    protected void registerStudentClick(){
        stage = (Stage) backButton.getScene().getWindow();
        HelloApplication.onWindowOpen("hello-view.fxml",stage);
    }
    @FXML
    protected void backToReception(){
        stage = (Stage) backButton.getScene().getWindow();
        HelloApplication.onWindowOpen("reception-view.fxml",stage);
    }
}
