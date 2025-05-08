package org.icesi.javafx.model;

import java.time.LocalDate;

public class Student {

    private String name;
    private String code;
    private boolean gender;
    private String dateString;
    private Mayer mayer;
    private String carrerString;
    private String genderString;
    private LocalDate date;

    public Student(String name, String code, boolean gender, String dateString, Mayer mayer) {
        this.name = name;
        this.code = code;
        this.gender = gender;
        this.dateString = dateString;
        this.mayer = mayer;
        this.genderString = gender ? "man" : "woman";
        date = LocalDate.parse(dateString);
        this.carrerString = mayer.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Mayer getMayer() {
        return mayer;
    }

    public void setMayer(Mayer mayer) {
        this.mayer = mayer;
    }

    public String getCarrerString() {
        return carrerString;
    }

    public void setCarrerString(String carrerString) {
        this.carrerString = carrerString;
    }

    public String getGenderString() {
        return genderString;
    }

    public void setGenderString(String genderString) {
        this.genderString = genderString;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Name: "+name+", Code: "+code+", Gender: "+genderString+", Date: "+date.toString() + "mayer: "+mayer.toString()+"\n";
    }
}
