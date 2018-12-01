package ru.shvartz.lab2.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO<T> {
    boolean insertTable(T user) throws SQLException;
    boolean updateTable (T user) throws SQLException;
    List<T> selectTable() throws SQLException;
    boolean deleteTable(int id) throws SQLException;
}
