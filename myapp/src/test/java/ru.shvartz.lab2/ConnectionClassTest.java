package ru.shvartz.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import ru.shvartz.lab2.SQL.ConnectionModel;
import ru.shvartz.lab2.dao.UserDAO;
import ru.shvartz.lab2.SQL.CRUDOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionClassTest {
    Connection connection = ConnectionModel.getDBConnection();
    private UserDAO user = new UserDAO(connection);
    private List<UserDAO> users = new ArrayList<>();

    CRUDOperations crudOperations = new CRUDOperations();

    @Test
    public void insertTest() throws SQLException{
        user.setId(6);
        user.setName("name");
        user.setEmail("mail");
        crudOperations.insertTable(user);
        assertEquals("6|name|mail",crudOperations.getById(6, user));
    }

    @Test
    public void getByIdTest() throws SQLException {
        Assert.assertEquals("0|null|null",crudOperations.getById(0, user));

    }

    @Test
    public void selectTest() throws SQLException {

        assertEquals("[0|null|null, 5|nameupdated|maillskdjflskdjf]", crudOperations.selectTable().toString());
    }

    @Test
    public void updateTest() throws SQLException{
        user = crudOperations.getUserById(5);
        user.setName("nameupdated");
        user.setEmail("maillskdjflskdjf");
        crudOperations.updateTable(user);
        assertEquals("5|nameupdated|maillskdjflskdjf", crudOperations.getById(5,user));
    }

    @Test
    public void deleteTest() throws SQLException{
        crudOperations.deleteTable(6);
        crudOperations.getById(6, user);
        assertEquals("null", "null");

    }
}