package ru.shvartz.lab2;

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
        this.driverName = "com.mysql.cj.jdbc.Driver";
    }

    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }
    public String getDriverName() {
        return driverName;
    }
}
