package ru.shvartz.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import ru.shvartz.lab2.SQL.ConnectionModel;
import ru.shvartz.lab2.models.User;
import ru.shvartz.lab2.models.implementations.UserDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionClassTest {
    Connection connection = ConnectionModel.getDBConnection();
    private User user = new User();
    private List<User> users = new ArrayList<>();

    UserDAOImpl userDAOImpl = new UserDAOImpl();

    @Test
    public void insertTest() throws SQLException{
        user.setId(6);
        user.setName("name");
        user.setEmail("mail");
        userDAOImpl.insertTable(user);
        assertEquals("6|name|mail", userDAOImpl.getById(6, user));
    }

    @Test
    public void getByIdTest() throws SQLException {
        Assert.assertEquals("0|null|null", userDAOImpl.getById(0, user));

    }

    @Test
    public void selectTest() throws SQLException {

        assertEquals("[0|null|null, 5|nameupdated|maillskdjflskdjf]", userDAOImpl.selectTable().toString());
    }

    @Test
    public void updateTest() throws SQLException{
        user = userDAOImpl.getUserById(5);
        user.setName("nameupdated");
        user.setEmail("maillskdjflskdjf");
        userDAOImpl.updateTable(user);
        assertEquals("5|nameupdated|maillskdjflskdjf", userDAOImpl.getById(5,user));
    }

    @Test
    public void deleteTest() throws SQLException{
        userDAOImpl.deleteTable(6);
        userDAOImpl.getById(6, user);
        assertEquals("null", "null");

    }
}