DROP DATABASE IF EXISTS EAD;
create database EAD;

use EAD;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id INT AUTO_INCREMENT NOT NULL,
    firstName varchar(40) not null,
    lastName varchar(40) not null,
    fatherName varchar(40) not null,
    email varchar(40) not null,
    class int not null,
    age int not null,
    unique key (email),
    primary key(id)
    );
    
select * from student;

insert into student values(null, 'Raghu','sharma', 'Ramesh Sharma','rahul.saini@metacube.com', 5, 22);
