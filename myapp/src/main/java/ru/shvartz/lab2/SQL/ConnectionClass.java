package ru.shvartz.lab2.SQL;

import ru.shvartz.lab2.dao.UserDAO;

import java.sql.*;
import java.util.Scanner;

public class ConnectionClass {


    public static void main(String[] args) throws SQLException {
        //Connection connection = ConnectionModel.getDBConnection();

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите команду");

       int command = 0;

       CRUDOperations crudOperations = new CRUDOperations();
       try {
            do {
                System.out.println("1 - insert, 2 - update, 3 - select, 4 - delete");
                command = scan.nextInt();
                switch (command) {
                    case 1: {
                        crudOperations.insertTable(new UserDAO(5, "namelksjd", "mail@mail.ru"));
                        break;
                    }
                    case 2: {
                        crudOperations.updateTable( new UserDAO(3,"nameupdated", "mailupdated"));
                        break;
                    }
                    case 3: {
                        crudOperations.selectTable();
                        break;
                    }
                    case 4: {
                        System.out.println("Введите id объекта");
                        crudOperations.deleteTable(scan.nextInt());
                        break;
                    }
                    case 5: {
                        crudOperations.getUserById(5);
                    }
                }
            } while (command != 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            //connection.close();
        }
    }



}
