create table PERSON (
    name varchar(100) not null,
    age INT ,
    address varchar(255),
    dob date,
    gender int,
    height int,
    qualification varchar(100),
    id VARCHAR(255) PRIMARY KEY
);

insert into PERSON (id,name, age) values (1,'Oracle_1', 10);
