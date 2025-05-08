package org.icesi.javafx.model;

import java.util.*;

public class Teacher {

    private String name;
    private String subject;
    private Course course;
    private String password;

    public Teacher(String name, String subject, String password) {
        this.name = name;
        this.subject = subject;
        this.course = null;
        this.password = password;
     }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Subject: "+subject+" Curse: "+course.getName();
    }
}
