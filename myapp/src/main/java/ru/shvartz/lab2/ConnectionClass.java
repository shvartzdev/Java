package ru.shvartz.lab2;

import java.sql.*;
import ru.shvartz.lab2.ConnectionModel;

public class ConnectionClass {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = getDBConnection();

        try {
            createTable(connection);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }

    }

    public static void dropDatabase(Connection connection) throws SQLException {
        Statement statement = null;
        String dropTableString = "DROP DATABASE lab2";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(dropTableString);
            System.out.println("database dropped");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void insertTable(Connection connection) throws SQLException {

        Statement statement = null;

        String insertTable = "INSERT INTO USER VALUES"
                + "('1','usname','pass', 'mail','1', '12.08.2018')," +
                "('1','usname','pass', 'mail','1', '12.08.2018')";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(insertTable);
            System.out.println("insertion done");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void createTable(Connection connection) throws SQLException {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE USER("
                + "userId int NOT NULL, "
                + "username VARCHAR(20) NOT NULL, "
                + "password VARCHAR(20) NOT NULL, "
                + "email VARCHAR(20) NOT NULL, "
                + "courseID int NOT NULL, "
                + "createdDate date not null,"
                + "PRIMARY KEY (userId) "
                + ")";

        String createTableCourses =
                "CREATE TABLE COURSE("
                        + "courseId int NOT NULL, "
                        + "courseName VARCHAR(20) NOT NULL, "
                        + "courseDescription VARCHAR(20) NOT NULL, "
                        + "PRIMARY KEY (courseId) "
                        + ")";
        try {
            connection = getDBConnection();
            statement = connection.createStatement();

            statement.execute(createTableSQL);
            statement.execute(createTableCourses);
            System.out.println("table \"user\" and \"course\" were created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void deleteTable(Connection connection) throws SQLException {
        String deleteUser = "delete from user where userId = 1";
        Statement statement = null;
        try {
            connection = getDBConnection();
            statement = connection.createStatement();

            statement.execute(deleteUser);
            System.out.println("user is deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void select(Connection connection) throws SQLException {
        Statement statement = null;
        String selectTable = "select * from user";

        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery(selectTable);

            while (res.next()) {
                String userId = res.getString("userId");
                String username = res.getString("username");

                System.out.println("userId: " + userId);
                System.out.println("username: " + username);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void update(Connection connection) {

        String updateTable = "UPDATE USER SET username = 'michail'";
        connection = null;
        Statement statement = null;
        try {
            connection = getDBConnection();
            statement = connection.createStatement();

            statement.execute(updateTable);
            System.out.println("record was updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static Connection getDBConnection() {
        ConnectionModel connectionModel = new ConnectionModel("localhost",3306, "lab2","root","AkwcEcsE");
        Connection connection = null;
        try {
            Class.forName(connectionModel.getDriverName());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(connectionModel.getUrl(), connectionModel.getUser(), connectionModel.getPassword());
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
