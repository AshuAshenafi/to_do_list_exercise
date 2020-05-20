package com.example.demo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ToDo {
    private int id;

    @NotNull
    @Size(min=3)
    private String name;

    @NotNull
    @Size(min=3)
    private String description;

    @NotNull
    private int priority;

    @NotNull
    private String date;


    private String picture;


    private boolean isCompleted;
//    private boolean isCompleted;

    public ToDo() {
    }

    public int getId() {
        return id;
    }

    public ToDo(int id, String name, String description, int priority, String date, String picture, boolean isCompleted) {
//    public ToDo(int id, String name, String description, int priority, String date, String picture, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.picture = picture;
        this.isCompleted = isCompleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
