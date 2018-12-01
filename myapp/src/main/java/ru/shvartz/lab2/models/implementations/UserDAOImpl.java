package ru.shvartz.lab2.models.implementations;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.shvartz.lab2.SQL.ConnectionModel;
import ru.shvartz.lab2.SQL.Constants;
import ru.shvartz.lab2.interfaces.UserDAO;
import ru.shvartz.lab2.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO<User> {

    private Connection connection = ConnectionModel.getDBConnection();
    public UserDAOImpl() {
        Connection connection = ConnectionModel.getDBConnection();
    }

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public String getById(int id, User user) throws SQLException {
        PreparedStatement preparedStatement;
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

    public User getUserById(int id) throws SQLException {
        User user = null;
        String selection = "select * from users where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(selection);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            user = new User(id,name,email);
        }
        resultSet.close();
        preparedStatement.close();

        return user;
    }

    @Override
    public boolean insertTable(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean rowInserted = false;
        try {
            preparedStatement = connection.prepareStatement(Constants.getInsertIntoTable(),
                    preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, user.getId());

            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.execute();
            System.out.println("insert the record. id = " + user.getId());
            rowInserted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("insertTable method failed");
            System.out.println(e.getMessage());
        }
        return rowInserted;
    }

    @Override
    public  boolean updateTable (User user) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(Constants.getUpdateTableName());
        boolean rowUpdated = false;
        try {
            preparedStatement.setInt(3, user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            rowUpdated = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("updateTable failed");
            System.out.println(e.getMessage());
        }
        return rowUpdated;
    }

    @Override
    public List<User> selectTable() throws SQLException {

        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(Constants.getSelectFromTable());
        ResultSet resultSet = preparedStatement.executeQuery();

        try {
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("email")));
                //System.out.print(resultSet.getInt(1) + "|");
                //System.out.print(resultSet.getString(2) + "|");
                //System.out.println(resultSet.getString(3) + "|");
            }
        } catch (SQLException e) {
            System.out.println("selectTable failed");
            System.out.println(e.getMessage());
        }
        //users.get(1);
        return users;
    }

    @Override
    public boolean deleteTable( int id) throws  SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(Constants.getDeleteFromTable());
        boolean rowDeleted = false;
        try {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch(SQLException e) {
            System.out.println("deleteTable was failed");
            System.out.println(e.getMessage());
        }
        return rowDeleted;
    }

}
