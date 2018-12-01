package ru.shvartz.lab2.models;

import lombok.Data;

@Data
public class Cource {
    private int id;
    private String name;
    private String description;

    public Cource(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}