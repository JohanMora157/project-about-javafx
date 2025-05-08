package org.icesi.javafx.control;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.icesi.javafx.HelloApplication;
import org.icesi.javafx.model.Mayer;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    private Stage stage;

    @FXML
    private SchoolController school;

    @FXML
    private TextField code;

    @FXML
    private TextField name;

    @FXML
    private ComboBox<Mayer> mayers;

    @FXML
    private CheckBox man;

    @FXML
    private CheckBox women;

    @FXML
    private DatePicker birthday;


    @FXML
    private Button backButton;

    @FXML
    private Button goToTeacherRegister;

    @FXML
    private ComboBox<String> subjetPicker;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        school = SchoolController.getInstance();
        subjetPicker.getItems().addAll("Maths", "Physics", "Chemistry", "Biology", "History");
        mayers.getItems().addAll(Mayer.values());
    }

    @FXML
    protected void onHelloButtonClick() {
        String nameText = name.getText();
        String codeText = code.getText();
        boolean gender = man.isSelected();
        String birthdayText = birthday.getValue().toString();
        Mayer mayer = mayers.getValue();
        String courseText = subjetPicker.getValue();

        if(school.addStudent(nameText, codeText,gender, birthdayText, mayer, courseText)) name.setText("success registered "+nameText);
        else name.setText("error");
    }

    @FXML
    protected void backClick(){
        stage = (Stage) backButton.getScene().getWindow();
        HelloApplication.onWindowOpen("reception-view.fxml",stage);
    }

    @FXML
    protected void registerTeacherClick(){
        stage = (Stage) goToTeacherRegister.getScene().getWindow();
        HelloApplication.onWindowOpen("register-teacher-view.fxml",stage);
    }

}