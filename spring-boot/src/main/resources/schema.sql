create table PERSON (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) not null,
    dob date ,
    gender varchar(100),
    height INT,
    age INT not null
);

create table EMAIL(
    EMAIL varchar(100) not null,
    person_id int,
    id INT
);

ALTER TABLE EMAIL
ADD CONSTRAINT EMAIL_ID_FK
FOREIGN KEY (person_id) REFERENCES Person;

-- -- ORACLE
-- create table PERSON (
-- id NUMBER GENERATED BY DEFAULT AS IDENTITY,
--     age NUMBER not null,
--     name varchar(100) not null,
--     PRIMARY KEY(id)
-- );
