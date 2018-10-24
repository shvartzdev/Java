DROP DATABASE lab2;
CREATE DATABASE lab2;
use lab2;
 CREATE TABLE USER(
             userId int NOT NULL,
             username VARCHAR(20) NOT NULL,
             password VARCHAR(20) NOT NULL,
             email VARCHAR(20) NOT NULL,
             courseID int NOT NULL,
             createdDate date not null,
            PRIMARY KEY (userId));

 CREATE TABLE COURSE(
            courseId int NOT NULL,
            courseName VARCHAR(20) NOT NULL,
            courseDescription VARCHAR(20) NOT NULL,
            PRIMARY KEY (courseId)
         );

INSERT INTO USER VALUES
            ('1','usname','pass', 'mail','1', '12.08.2018'),
            ('2','usname','pass', 'mail','1', '12.08.2018');

INSERT INTO COURSE VALUES
            ('1','name1','description1'),
            ('2','name2','description2');

delete from user;
delete from course;