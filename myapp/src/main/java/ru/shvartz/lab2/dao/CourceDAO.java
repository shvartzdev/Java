package ru.shvartz.lab2.dao;

import lombok.Data;
import lombok.Getter;

@Data
public class CourceDAO {
    private int id;
    private String name;
    private String description;

    public CourceDAO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}