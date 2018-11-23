package ru.shvartz.lab2.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionModel {
    private String host;
    private int port;
    private String database;
    private String user;
    private String password;
    private String url;
    private String driverName;

    public ConnectionModel(String host, int port, String database, String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?serverTimezone=UTC";
        this.driverName = "com.mysql.jdbc.Driver";
    }

    public String getUser() { return user; }
    public String getPassword() { return password; }
    public String getUrl() { return url; }
    public String getDriverName() { return driverName; }

    public static Connection getDBConnection() {
        ConnectionModel connectionModel = new ConnectionModel("localhost", 3306, "lab2", "root", "AkwcEcsE");
        Connection connection = null;
        try {
            Class.forName(connectionModel.getDriverName());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(connectionModel.getUrl(), connectionModel.getUser(), connectionModel.getPassword());
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}