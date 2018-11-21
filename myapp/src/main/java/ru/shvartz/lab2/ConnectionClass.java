package ru.shvartz.lab2;

import java.sql.*;
import java.util.Scanner;

public class ConnectionClass {

    private static final String insertIntoTable = "INSERT INTO users (id, name, email) VALUES(?,?,?)";
    private static final String selectFromTable = "SELECT * FROM users  LIMIT 10";
    private static final String deleteFromTable = "DELETE FROM users where id = ?";
    private static final String updateTableName = "UPDATE users SET name = ? where id = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionModel.getDBConnection();
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите команду");




       int command = 0;

        try {
            do {

                System.out.println("1 - insert, 2 - update, 3 - select, 4 - delete");

                command = scan.nextInt();
                switch (command) {
                    case 1: {
                        System.out.println("Введите количество записей");
                        int i = scan.nextInt();
                        int count = 0;
                        while (count < i) {
                            insertTable(connection);
                            count++;
                        }
                        break;
                    }
                    case 2: {
                        updateTable(connection);
                        break;
                    }
                    case 3: {
                        selectTable(connection);
                        break;
                    }
                    case 4: {
                        deleteTable(connection);
                        break;
                    }
                }
            } while (command != 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }



    public static void insertTable(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Введите id пользователя");
            int idUser = scan.nextInt();
            System.out.println("Введите имя пользователя");
            String nameUser = scan.next();
            System.out.println("Введите mail пользователя");
            String mailUser = scan.next();
            preparedStatement = connection.prepareStatement(insertIntoTable, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setString(2, nameUser);
            preparedStatement.setString(3, mailUser);
            preparedStatement.execute();
            preparedStatement.getGeneratedKeys();
            System.out.println("Table was created");
        } catch (SQLException e) {
            System.out.println("CreateTable method failed");
            System.out.println(e.getMessage());
        }
    }

    public static void updateTable (Connection connection) throws SQLException{
        Scanner scan = new Scanner(System.in);
        PreparedStatement preparedStatement = connection.prepareStatement(updateTableName);
        System.out.println("Введите id пользователя");
        System.out.println("Введите новое имя пользователя");
        try {
            preparedStatement.setInt(2, scan.nextInt());
            preparedStatement.setString(1, scan.next());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateTable failed");
            System.out.println(e.getMessage());
        }
    }

    public static void selectTable(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(selectFromTable);
        ResultSet resultSet = preparedStatement.executeQuery();

        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) + "|");
                System.out.print(resultSet.getString(2) + "|");
                System.out.println(resultSet.getString(3) + "|");
            }
        } catch (SQLException e) {
            System.out.println("selectTable failed");
            System.out.println(e.getMessage());
        }
    }

     public static void deleteTable(Connection connection) throws  SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(deleteFromTable);
        System.out.println("Введите id пользователя");
        Scanner scan = new Scanner(System.in);

        try {
            preparedStatement.setInt(1, scan.nextInt());
            preparedStatement.execute();
        } catch(SQLException e) {
            System.out.println("deletetable was failed");
            System.out.println(e.getMessage());
        }
     }
}
