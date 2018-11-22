package ru.shvartz.lab2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperations implements DAO {

    private static final String insertIntoTable = "INSERT INTO users (id, name, email) VALUES(?,?,?)";
    private static final String selectFromTable = "SELECT * FROM users  LIMIT 10";
    private static final String deleteFromTable = "DELETE FROM users where id = ?";
    private static final String updateTableName = "UPDATE users SET name = ?, email = ? where id = ?";


    public void getById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("Select from user where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("record with id = " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public  void insertTable(Connection connection, UserDAO user) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertIntoTable, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.execute();
            System.out.println("insert the record. id = " + user.getId());
        } catch (SQLException e) {
            System.out.println("CreateTable method failed");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public  void updateTable (Connection connection, UserDAO user) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(updateTableName);

        try {
            preparedStatement.setInt(3, user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateTable failed");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<UserDAO> selectTable(Connection connection) throws SQLException {

        List<UserDAO> users = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(selectFromTable);
        ResultSet resultSet = preparedStatement.executeQuery();

        try {
            while (resultSet.next()) {
                users.add(new UserDAO(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email")));
                System.out.print(resultSet.getInt(1) + "|");
                System.out.print(resultSet.getString(2) + "|");
                System.out.println(resultSet.getString(3) + "|");
            }
        } catch (SQLException e) {
            System.out.println("selectTable failed");
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public  void deleteTable(Connection connection, int id) throws  SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(deleteFromTable);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            System.out.println("deleteTable was failed");
            System.out.println(e.getMessage());
        }
    }

}
