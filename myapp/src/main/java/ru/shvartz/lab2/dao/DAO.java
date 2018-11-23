package ru.shvartz.lab2.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    String insertTable(T user) throws SQLException;
    void updateTable (T user) throws SQLException;
    List<T> selectTable() throws SQLException;
    void deleteTable(int id) throws SQLException;
}
