package ru.shvartz.lab2;

import java.sql.Connection;

public class UserDAO  {
    private int id;
    private String name;
    private String email;
    private int courseId;


    public int getId() {
        return id;
    }

    public UserDAO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        //this.courseId = courseId;
    }

    public UserDAO(Connection connection) {
        this.id = 1;
        this.name = "name1";
        this.email = "mail";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCourseId() {
        return courseId;
    }
}
