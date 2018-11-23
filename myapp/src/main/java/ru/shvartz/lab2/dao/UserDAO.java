package ru.shvartz.lab2.dao;


import lombok.Getter;
import lombok.Setter;
import ru.shvartz.lab2.SQL.ConnectionModel;

import java.sql.Connection;

@Getter
@Setter
public class UserDAO  {
    private int id;
    private String name;
    private String email;
    private int courseId;


    Connection connection = ConnectionModel.getDBConnection();
    public UserDAO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        //this.courseId = courseId;
    }

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return getId() + "|" + getName() + "|" + getEmail();
    }
}
