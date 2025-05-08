package org.icesi.javafx.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.icesi.javafx.model.Course;
import org.icesi.javafx.model.Mayer;
import org.icesi.javafx.model.Student;
import org.icesi.javafx.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SchoolController {

    private static SchoolController instance;
    private Course currentCourse;
    private ObservableList<Course> courses;

    //se crea el singleton para que no se creen instancias de la clase y se pueda acceder a los cursos y profesores
    public static SchoolController getInstance() {
        if (instance == null) {
            instance = new SchoolController();
        }
        return instance;
    }

    public SchoolController() {
        courses = FXCollections.observableArrayList();

        courses.add(new Course("Maths"));
        courses.add(new Course("Physics"));
        courses.add(new Course("Chemistry"));
        courses.add(new Course("Biology"));
        courses.add(new Course("History"));

        currentCourse = getCourse("Maths");

    }

    public boolean addStudent(String name, String code, boolean gender, String dateString, Mayer mayer, String courseName) {
        Course c = getCourse(courseName);

        Student student = new Student(name, code, gender, dateString, mayer);

        return c.addStudent(student);
    }

    public Course getCourse(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }


    public ObservableList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ObservableList<Course> courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        for (Course course : courses) {
            if (course.getTeacher() != null) {
                teachers.add(course.getTeacher());
            }
        }
return teachers;
    }

    public void currentCourse(String name) {
       Course course = getCourse(name);
       this.currentCourse = course;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }
}
