package com.student_tracker.student_tracker_app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private int weight;
    private int height;
    private String hair_colour;
    private Double gpa;
    public User() {
    }
    public User(String name, int weight, int height, String hair_colour, Double gpa) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hair_colour = hair_colour;
        this.gpa = gpa;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getHair_colour() {
        return hair_colour;
    }
    public void setHair_colour(String hair_colour) {
        this.hair_colour = hair_colour;
    }
    public Double getGpa() {
        return gpa;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    
}
