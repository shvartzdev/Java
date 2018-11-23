package ru.shvartz.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ru.shvartz.lab2.SQL.ConnectionModel;

import java.sql.Connection;

public class ConnectingTest
{

    @Test
    public void getConnection() {
        Connection connection = ConnectionModel.getDBConnection();
        ConnectionModel connectionModel = new ConnectionModel("localhost", 3306, "lab2", "root", "AkwcEcsE");
        //System.out.println(connectionModel.getUrl());
        assertEquals("jdbc:mysql://localhost:3306/lab2?serverTimezone=UTC",connectionModel.getUrl());
    }
}
