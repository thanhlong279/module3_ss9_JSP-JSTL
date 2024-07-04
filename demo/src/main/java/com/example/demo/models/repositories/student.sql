create database C0324H1;
use c0324h1;

create table student(
    id int primary key auto_increment,
    name varchar(100),
    address varchar(100),
    point float
);

alter table student add id_class int null ;

create table classroom(
    id_class int primary key auto_increment,
    name_class varchar(50)
);

drop table classroom;

alter table student add constraint student_classroom_id_class_fk
foreign key (id_class) references classroom(id_class);

