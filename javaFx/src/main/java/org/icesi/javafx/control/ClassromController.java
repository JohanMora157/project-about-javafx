package org.icesi.javafx.control;

 import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.icesi.javafx.HelloApplication;
import org.icesi.javafx.model.Student;
import org.icesi.javafx.model.Teacher;


import java.net.URL;
import java.util.ResourceBundle;

public class ClassromController implements Initializable {
    private Stage stage;
    private SchoolController school;

    @FXML
    private Button goBackToReception;

    @FXML
    private Label infoTeacher;

    @FXML
    private TableView<Student> tableStudents;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> codeColumn;

    @FXML
    private TableColumn<Student, String> genderColum;

    @FXML
    private TableColumn<Student, String> dateColum;

    @FXML
    private TableColumn<Student, String> carrerColum;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        school = SchoolController.getInstance();

        tableStudents.setItems(school.getCurrentCourse().getStudents());

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Student, String>("name"));
        codeColumn.setCellValueFactory(
                new PropertyValueFactory<Student, String>("code"));

        genderColum.setCellValueFactory(
                new PropertyValueFactory<Student, String>("genderString"));

        dateColum.setCellValueFactory(
                new PropertyValueFactory<Student, String>("dateString"));

        carrerColum.setCellValueFactory(
                new PropertyValueFactory<Student, String>("carrerString"));

        Teacher teacher = school.getCurrentCourse().getTeacher();
        infoTeacher.setText(teacher.getName()+" "+teacher.getSubject());
    }

    @FXML
    protected void goToReception(){
        stage = (Stage) goBackToReception.getScene().getWindow();
        HelloApplication.onWindowOpen("reception-view.fxml",stage);
    }



}
