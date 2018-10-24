create table if not exist user (
                userId int not null auto_increment primary key,
                username VARCHAR(20) NOT NULL,
                password VARCHAR(20) NOT NULL,
                email VARCHAR(20) NOT NULL,
                courseID int NOT NULL,
                createdDate date not null,
                constraint foreign key courseIDFK (courseID) references course(courseId) on delete restrict
                );

create table if not exist course (
   courseId int not null auto_increment,
   courseName varchar(20) not null,
   courseDescription varchar(20) not null


);