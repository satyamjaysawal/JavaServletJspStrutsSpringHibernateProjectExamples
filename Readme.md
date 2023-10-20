CrudProject Using Hibernate, Mysql, Java 1.8 ::


create database hibernate_db;
use hibernate_db;
CREATE TABLE Student (
    id INT AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    collegeName VARCHAR(255),
    email VARCHAR(255),
    PRIMARY KEY (id)
);
INSERT INTO Student (name, address, collegeName, email) 
VALUES ('Becoder2O', 'India2O', 'Uks2O University', 'sj2O@gmail.com');

select * from Student;
truncate table Student;

![image](https://github.com/satyamjaysawal/JavaServletJspProjectExamples/assets/108862706/146ec24b-5fd0-48b7-ba8c-9f943171ac32)
