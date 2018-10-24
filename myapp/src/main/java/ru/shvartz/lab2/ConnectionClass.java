package ru.shvartz.lab2;

import java.sql.*;


public class ConnectionClass {

    public static void main(String[] args) throws SQLException {
        workingSQL();
    }

    public static void workingSQL() throws SQLException {
        Connection connection = getDBConnection();
        try {
            sqlCommands commands = new sqlCommands();
            sqlTasks.doCommand(connection, commands.getDropDatabaseString());
            System.out.println("database was dropped");
            sqlTasks.doCommand(connection, commands.getCreateDataBaseString());
            System.out.println("database was created");
            sqlTasks.doCommand(connection, commands.getUseDatabase());
            sqlTasks.doCommand(connection, commands.getCreateUser());
            sqlTasks.doCommand(connection, commands.getCreateCourse());
            sqlTasks.doCommand(connection, commands.getDeleteAllFromUser());
            sqlTasks.doCommand(connection, commands.getDeleteAllFromCourse());
            sqlTasks.doCommand(connection, commands.getInsertTableUser());
            sqlTasks.doCommand(connection, commands.getInsertTableCourse());

            sqlTasks.select(connection,"user");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }

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
