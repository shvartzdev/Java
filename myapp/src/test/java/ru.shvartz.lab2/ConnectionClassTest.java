package ru.shvartz.lab2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ru.shvartz.lab2.UserDAO;

import java.sql.Connection;

public class ConnectionClassTest {
    Connection connection = ConnectionModel.getDBConnection();
    private UserDAO users = new UserDAO(connection);

    @Test
    public void selectTest() {

    }

    @Test
    public void insertTest() {

    }

    @Test
    public void updateTest() {

    }

    @Test
    public void deleteTest() {

    }
}