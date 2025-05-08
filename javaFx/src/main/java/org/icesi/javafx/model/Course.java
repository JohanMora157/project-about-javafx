package org.icesi.javafx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Course {

    private String name;
    private ObservableList<Student> students;
    private Teacher teacher;

    public Course(String name) {
        students = FXCollections.observableArrayList();
        this.name = name;
        this.teacher = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    public void setStudents(ObservableList<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String printStudents() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean addStudent(Student student) {

        if(student == null) {
            return false;
        }else {
            students.add(student);
            return true;
        }
    }

    @Override
    public String toString() {
        return "Course: "+name+" Teacher: "+teacher.getName();
    }
}
