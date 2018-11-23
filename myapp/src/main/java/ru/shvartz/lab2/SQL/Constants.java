package ru.shvartz.lab2.SQL;


import lombok.Value;

@Value
public class Constants {

    private static final String insertIntoTable = "INSERT INTO users (id, name, email) VALUES(?,?,?)";
    private static final String selectFromTable = "SELECT * FROM users  LIMIT 10";
    private static final String deleteFromTable = "DELETE FROM users where id = ?";
    private static final String updateTableName = "UPDATE users SET name = ?, email = ? where id = ?";


    public static String getSelectFromTable() {
        return selectFromTable;
    }

    public static String getInsertIntoTable() {
        return insertIntoTable;
    }

    public static String getDeleteFromTable() {
        return deleteFromTable;
    }

    public static String getUpdateTableName() {
        return updateTableName;
    }
}
