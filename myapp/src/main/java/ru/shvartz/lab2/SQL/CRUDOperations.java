package ru.shvartz.lab2.SQL;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import ru.shvartz.lab2.dao.DAO;
import ru.shvartz.lab2.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperations implements DAO<UserDAO> {

    Connection connection = ConnectionModel.getDBConnection();

    public String getById(int id, UserDAO user) throws SQLException {
        PreparedStatement preparedStatement= null;
        try {

            preparedStatement = connection.prepareStatement("select from users where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("record with id = " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user.toString();
    }

    public UserDAO getUserById(int id) throws SQLException {

        List<UserDAO> users = new ArrayList<UserDAO>();
        users = selectTable();

        //System.out.println(users.get(id));

        for (UserDAO x: users)
              {
            if (x.getId() == id) {
                System.out.println("x= " + x.toString());
                return x;
            }
        }
        return users.get(id);
    }

    @Override
    public  String insertTable( UserDAO user) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Constants.getInsertIntoTable(),
                    preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, user.getId());

            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.execute();
            System.out.println("insert the record. id = " + user.getId());
        } catch (SQLException e) {
            System.out.println("CreateTable method failed");
            System.out.println(e.getMessage());
        }
        return user.getId() + "|" + user.getName() + "|" + user.getEmail();
    }

    @Override
    public  void updateTable (UserDAO user) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(Constants.getUpdateTableName());

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
    public List<UserDAO> selectTable() throws SQLException {

        List<UserDAO> users = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(Constants.getSelectFromTable());
        ResultSet resultSet = preparedStatement.executeQuery();

        try {
            while (resultSet.next()) {
                users.add(new UserDAO(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("email")));
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
    public  void deleteTable( int id) throws  SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(Constants.getDeleteFromTable());
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            System.out.println("deleteTable was failed");
            System.out.println(e.getMessage());
        }
    }

}
