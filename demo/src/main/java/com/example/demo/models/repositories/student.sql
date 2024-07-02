create database C0324H1;
use c0324h1;

create table student(
    id int primary key auto_increment,
    name varchar(100),
    address varchar(100),
    point float
);

update student set name = 'Hoang Dao'