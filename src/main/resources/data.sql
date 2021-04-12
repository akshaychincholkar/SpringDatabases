create table person
    (
       id integer not null,
       name varchar(255) not null,
       location varchar(255),
       birth_date timestamp,
       primary key(id)
    );

--INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
--VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
--INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
--VALUES(10002,  'James', 'New York',sysdate());
--INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
--VALUES(10003,  'Pieter', 'Amsterdam',sysdate());
--INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
--VALUES(10004,  'Akshay', 'Amsterdam',sysdate());

--CREATE TABLE ADDRESS
--(
--    ADDRESS_ID INTEGER NOT NULL,
--    STREET VARCHAR(50) NOT NULL,
--    CITY VARCHAR(100) NOT NULL,
--    IS_OPEN BOOLEAN NOT NULL,
--    X DOUBLE,
--    ADDED DATE NOT NULL,
--    IMAGE BLOB
--)