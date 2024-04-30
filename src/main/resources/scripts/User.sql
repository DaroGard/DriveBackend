CREATE USER C##DRIVE
  IDENTIFIED BY "oracle"
  DEFAULT TABLESPACE USERS
  TEMPORARY TABLESPACE TEMP;

ALTER USER C##DRIVE QUOTA UNLIMITED ON USERS;

GRANT create session TO C##DRIVE;
GRANT create table TO C##DRIVE;
GRANT create view TO C##DRIVE;
GRANT create any trigger TO C##DRIVE;
GRANT create any procedure TO C##DRIVE;
GRANT create sequence TO C##DRIVE;
GRANT create synonym TO C##DRIVE;
GRANT create materialized view TO C##DRIVE;