package ru.shvartz.lab2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DAO {
    void insertTable(Connection connection, UserDAO user) throws SQLException;
    void updateTable (Connection connection, UserDAO user) throws SQLException;
    List<UserDAO> selectTable(Connection connection) throws SQLException;
    void deleteTable(Connection connection, int id) throws SQLException;
}
