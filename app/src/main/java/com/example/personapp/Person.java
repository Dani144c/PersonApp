package com.example.personapp;

import com.google.gson.Gson;

public class Person {
    private int id;
    private String name;
    private String email;
    private String note;

    public Person() {
    }

    public Person(int id, String name, String email, String note) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.note = note;
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}