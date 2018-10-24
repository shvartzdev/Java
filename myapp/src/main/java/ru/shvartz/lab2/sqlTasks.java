package ru.shvartz.lab2;
import java.sql.*;
public class sqlTasks {

    private String command;
    public sqlTasks(String command) {
        this.command = command;
    }

    public static void doCommand(Connection connection, String command) throws SQLException{
        try {
          connection.prepareStatement(command).execute();
          } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

