package ru.shvartz.lab2;

import java.sql.*;

public class sqlTasks {

    public static void doCommand(Connection connection, String command) {
        try {
          connection.prepareStatement(command).execute();
          } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void select(Connection connection, String tableName) throws SQLException{
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(("select * from ").concat(tableName + ";"));
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                String id = res.getString("userId");
                String name = res.getString("username");
                System.out.println("id: " + id);
                System.out.println("name: " + name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

