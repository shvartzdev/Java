package ru.shvartz.lab2.models;


import lombok.Getter;
import lombok.Setter;
import ru.shvartz.lab2.SQL.ConnectionModel;

import java.sql.Connection;

@Getter
@Setter
public class User {

    public int id;
    private String name;
    private String email;
    private int courseId;
    Connection connection;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public User() {
        this.connection = ConnectionModel.getDBConnection();
    }

    @Override
    public String toString() {
        return getId() + "|" + getName() + "|" + getEmail();
    }
}
