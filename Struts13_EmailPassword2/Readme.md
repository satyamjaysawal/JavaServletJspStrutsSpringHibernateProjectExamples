struts 1.3 with Mysql Email Password login and Fetch all data from database ::

create database struts13db;
use struts13db;


CREATE TABLE urs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
INSERT INTO urs (name, email, password) VALUES
('Rahul', 'rahul@example.com', 'password123'),
('Priya', 'priya@example.com', 'securepwd456'),
('Mohan', 'mohan@example.com', 'secret789');

SELECT * FROM urs;
![image](https://github.com/satyamjaysawal/JavaServletJspStrutsSpringHibernateProjectExamples/assets/108862706/e263c25c-9e74-4795-a7ad-034db972d3d4)
![image](https://github.com/satyamjaysawal/JavaServletJspStrutsSpringHibernateProjectExamples/assets/108862706/94c87316-647a-446c-8c85-49a0c6958ada)
![image](https://github.com/satyamjaysawal/JavaServletJspStrutsSpringHibernateProjectExamples/assets/108862706/6a5ba281-9f72-4d30-83e2-9f1fbba81a36)

![image](https://github.com/satyamjaysawal/JavaServletJspStrutsSpringHibernateProjectExamples/assets/108862706/6515be39-d272-4c7a-a2c6-3228f2677afe)
