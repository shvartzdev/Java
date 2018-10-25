package ru.shvartz.lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ru.shvartz.lab2.dao.*;

public class ConnectionClass {

    public static void main(String[] args) throws SQLException {

        workingSQL();
    }

    private static void addUsers(UserDAO userDAO) throws Exception {
        for (User user : generateSomeUsers()) {
            userDAO.AddUser(user);
        }
    }

    private static void usingOperations(final UserDAO userDAO) throws Exception{
        addUsers(userDAO);
        try (Stream<User> userStream = userDAO.getAll()) {
            userStream.forEach(user -> System.out.println(user));
        }
        System.out.println(userDAO.getById(2));
        final User user = new User(4,"firstname4","lastname4");
        userDAO.AddUser(user);
        try (Stream<User> userStream = userDAO.getAll()) {
            userStream.forEach(users -> System.out.println(users));
        }
        user.setFirstName("u");
        user.setLastName("asdasd");
        userDAO.update(user);
        try (Stream<User> userStream = userDAO.getAll()) {
            userStream.forEach(users -> System.out.println(users));
        }

        userDAO.delete(user);


    }

    public static List<User> generateSomeUsers() {
        final User user1 = new User(1, "firstname","lastname");
        final User user2 = new User(2, "firstname2", "lastname2");
        final User user3 = new User(3, "firstname3", "lastname3");
        final List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    public static void workingSQL() throws SQLException {
        Connection connection = getDBConnection();
        try {
            sqlCommands commands = new sqlCommands();
            sqlTasks.doCommand(connection, commands.getDropDatabaseString());
            System.out.println("database was dropped");
            sqlTasks.doCommand(connection, commands.getCreateDataBaseString());
            System.out.println("database was created");
            sqlTasks.doCommand(connection, commands.getUseDatabase());
            sqlTasks.doCommand(connection, commands.getCreateUser());
            sqlTasks.doCommand(connection, commands.getCreateCourse());
            sqlTasks.doCommand(connection, commands.getDeleteAllFromUser());
            sqlTasks.doCommand(connection, commands.getDeleteAllFromCourse());
            sqlTasks.doCommand(connection, commands.getInsertTableUser());
            sqlTasks.doCommand(connection, commands.getInsertTableCourse());

            sqlTasks.select(connection,"user");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public static Connection getDBConnection() {
        ConnectionModel connectionModel = new ConnectionModel("localhost", 3306, "lab2", "root", "AkwcEcsE");
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
