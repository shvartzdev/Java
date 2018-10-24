package ru.shvartz.lab2;


public class sqlCommands {
    ConnectionModel connectionModel = new ConnectionModel();
    private String dropDatabaseString = "DROP DATABASE lab2;";
    private String createDataBaseString = "CREATE DATABASE lab2;";

    private String useDatabase = "use lab2;";
    private String createUser = "CREATE TABLE USER("
            + "userId int NOT NULL, "
            + "username VARCHAR(20) NOT NULL, "
            + "password VARCHAR(20) NOT NULL, "
            + "email VARCHAR(20) NOT NULL, "
            + "courseID int NOT NULL, "
            + "createdDate date not null,"
            + "PRIMARY KEY (userId) "
            + ")";
    private String createCourse = "CREATE TABLE COURSE("
            + "courseId int NOT NULL, "
            + "courseName VARCHAR(20) NOT NULL, "
            + "courseDescription VARCHAR(20) NOT NULL, "
            + "PRIMARY KEY (courseId) "
            + ")";

    private String insertTableUser = "INSERT INTO USER VALUES"
            + "('1','usname','pass', 'mail','1', '12.08.2018')," +
            "('2','usname','pass', 'mail','1', '12.08.2018')";


    private String insertTableCourse = "INSERT INTO COURSE VALUES" +
            "('1','name1','description1')," +
            "('2','name2','description2')";

    private String deleteFromTable = "delete from user where userId = 1";
    private String selectFromUser = "select * from user";
    private String selectFromCourse = "select * from course";
    private String updateUser = "UPDATE USER SET username = 'michail'";

    private String deleteAllFromUser = "delete from user;";
    private String deleteAllFromCourse = "delete from course;";

    public String getDeleteAllFromUser() {
        return deleteAllFromUser;
    }

    public String getDeleteAllFromCourse() {
        return deleteAllFromCourse;
    }

    public String getDropDatabaseString() {
        return dropDatabaseString;
    }

    public String getCreateDataBaseString() {
        return createDataBaseString;
    }

    public String getUseDatabase() {
        return useDatabase;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getCreateCourse() {
        return createCourse;
    }

    public String getInsertTableUser() {
        return insertTableUser;
    }

    public String getDeleteFromTable() {
        return deleteFromTable;
    }

    public String getSelectFromUser() {
        return selectFromUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }
    public String getInsertTableCourse() {
        return insertTableCourse;
    }

    public String getSelectFromCourse() {
        return selectFromCourse;
    }

}
